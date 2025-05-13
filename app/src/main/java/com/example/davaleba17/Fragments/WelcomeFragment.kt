package com.example.davaleba17.Fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.davaleba17.BaseFragment
import com.example.davaleba17.R
import com.example.davaleba17.databinding.FragmentWelcomeBinding

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>(FragmentWelcomeBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.registerButton.setOnClickListener{
            findNavController().navigate(R.id.action_welcomeFragment_to_registerFragment)
        }
        binding.loginButton.setOnClickListener{
            findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment)
        }
    }

}