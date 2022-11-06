package com.example.examencoppel.marvel.superherodetail.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.examencoppel.R
import com.example.examencoppel.databinding.FragmentSuperHeroDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SuperHeroDetailFragment : Fragment() {

    lateinit var binding: FragmentSuperHeroDetailBinding
     private val args: SuperHeroDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSuperHeroDetailBinding.inflate(layoutInflater)

        var nameComics=""
        var nameSeries = ""
        var nameStories = ""
        var nameEvents = ""

        Glide.with(requireContext()).load("${args.detailSuperhero?.thumbnailModel?.path}.${args.detailSuperhero?.thumbnailModel?.extension}")
            .into(binding.imvSuperhero)
        binding.txvAvailableComics.text = "${args.detailSuperhero?.comicsModel?.available}"
        binding.txvAvailableSeries.text = "${args.detailSuperhero?.seriesModel?.available}"
        binding.txvAvailableStories.text = "${args.detailSuperhero?.storiesModel?.available}"
        binding.txvAvailableEvents.text = "${args.detailSuperhero?.eventsModel?.available}"

        args.detailSuperhero?.comicsModel?.itemModels?.forEach {
                x-> nameComics+= "${x.name}\n"
        }
        args.detailSuperhero?.seriesModel?.itemModels?.forEach {
                x-> nameSeries+= "${x.name}\n"
        }
        args.detailSuperhero?.storiesModel?.items?.forEach {
                x-> nameStories+= "${x.name}\n"
        }
        args.detailSuperhero?.eventsModel?.itemModels?.forEach {
                x-> nameEvents+= "${x.name}\n"
        }
        binding.txvNameComics.text = nameComics
        binding.txvNameSeries.text = nameSeries
        binding.txvNameStories.text = nameStories
        binding.txvNameEvents.text = nameEvents


        return binding.root
    }
}