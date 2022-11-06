package com.example.examencoppel.marvel.ui.view

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examencoppel.R
import com.example.examencoppel.databinding.FragmentMarvelBinding
import com.example.examencoppel.marvel.adapters.MarvelFragmentAdapter
import com.example.examencoppel.marvel.model.SuperHeroModel
import com.example.examencoppel.marvel.ui.viewmodel.MarvelFragmentVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MarvelFragment : Fragment() {

    private lateinit var binding: FragmentMarvelBinding
    private val marvelFragmentVM: MarvelFragmentVM by viewModels()
    var superHeroModelList: List<SuperHeroModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity() as MenuHost).addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_item,menu)
            }
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when(menuItem.itemId){
                    R.id.sign_out->{
                        marvelFragmentVM.deleteUserDB()
                        findNavController().navigate(MarvelFragmentDirections.actionMarvelFragmentToLoginFragment())
                        return true
                    }
                }
                return false
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMarvelBinding.inflate(layoutInflater)
        marvelFragmentVM.onCreate()
        observers()
        binding.svSuperhero.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.svSuperhero.clearFocus()
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                superHeroModelList?.let { marvelFragmentVM.search(it,newText.lowercase()) }
                return false
            }
        })
        onBackPressed()
        return binding.root
    }


    private fun observers() {
        marvelFragmentVM.marvelModel.observe(viewLifecycleOwner) {
            superHeroModelList = it
            initRecyclerView(it)
        }
        marvelFragmentVM.isLoading.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }
        marvelFragmentVM.searchmarvelModel.observe(viewLifecycleOwner) {
            initRecyclerView(it)
        }
    }

    private fun initRecyclerView(superHero:List<SuperHeroModel>) {
        val manager = LinearLayoutManager(requireContext())
        binding.rcvSuperheros.layoutManager = manager
        binding.rcvSuperheros.adapter = MarvelFragmentAdapter(superHero) { superheros ->
            onItemSelected(superheros)
        }
    }

    private fun onItemSelected(superheros: SuperHeroModel) {
        var detailSuperhero = superHeroModelList?.first { x -> x.id == superheros.id }
        findNavController().navigate(MarvelFragmentDirections.actionMarvelFragmentToSuperHeroDetailFragment(detailSuperhero))
    }

    private fun onBackPressed() {
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    requireActivity().finish()
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }
}