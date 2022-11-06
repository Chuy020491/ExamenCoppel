package com.example.examencoppel.login.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.examencoppel.R
import com.example.examencoppel.databinding.FragmentLoginBinding
import com.example.examencoppel.login.model.UserModel
import com.example.examencoppel.login.ui.viewmodel.LoginFragmentVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val loginFragmentVM: LoginFragmentVM by viewModels()
    lateinit var email:String
    lateinit var password:String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater)
        loginFragmentVM.onCreate()
        observers()
        onClicks()
        onBackPressed()
        return binding.root
    }



    private fun observers() {
        loginFragmentVM.userExisting.observe(viewLifecycleOwner){
            if(it != null){
                binding.loginLayout.visibility = View.INVISIBLE
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToMarvelFragment())

            }
        }


        loginFragmentVM.insertUser.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(),it, Toast.LENGTH_SHORT).show()
        }

        loginFragmentVM.correctSignIn.observe(viewLifecycleOwner) {
            if(it == true){
                var user = UserModel(0,email,password)
                loginFragmentVM.insertUserDB(user)
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToMarvelFragment())

            }else{
                Toast.makeText(requireContext(),"A ocurrido un erro al tratar de iniciar sesion",
                    Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun onClicks(){
        binding.txvCheckin.setOnClickListener {
            if(validateEditText()){
                loginFragmentVM.insertUserFirebase(email,password)
            }
        }
        binding.btnLogin.setOnClickListener {
            if(validateEditText()){
                loginFragmentVM.signIn(email,password)
            }

        }
        binding.imvGoogle.setOnClickListener {
            unfinishedFunctionality()
        }

        binding.imvFacebook.setOnClickListener {
            unfinishedFunctionality()
        }
        binding.imvTwittew.setOnClickListener {
            unfinishedFunctionality()
        }
        binding.edtEmail.editText?.doAfterTextChanged {
            binding.edtEmail.error = null
        }

        binding.edtPassword.editText?.doAfterTextChanged {
            binding.edtPassword.error = null
        }

    }

    private fun unfinishedFunctionality(){
        Toast.makeText(requireContext(),"Por tiempo no pude desarrollarlo",Toast.LENGTH_SHORT).show()
    }

    private fun validateEditText():Boolean
    {
        email = binding.edtEmail.editText?.text.toString().trim { it <= ' ' }
        password = binding.edtPassword.editText?.text.toString().trim { it <= ' ' }
        if(email.isEmpty())
        {
            binding.edtEmail.error = "Campo requerido"
            return false
        }else if(password.isEmpty())
        {
            binding.edtPassword.error = "Campo requerido"
            return false
        }

        return true
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