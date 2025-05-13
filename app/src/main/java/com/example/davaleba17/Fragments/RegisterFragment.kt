package com.example.davaleba17.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.davaleba17.BaseFragment
import com.example.davaleba17.R
import com.example.davaleba17.ViewModels.RegistrationViewModel
import com.example.davaleba17.databinding.FragmentRegisterBinding

class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

    private val viewModel: RegistrationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            registerButton.setOnClickListener {
                val email = emailField.text.toString().trim()
                val username = usernameField.text.toString().trim()
                val password = passwordField.text.toString().trim()

                val list = listOf(email, username, password)

                if (list.any { it.isEmpty() }) {
                    showError("Please fill in all the fields!")
                    return@setOnClickListener
                }
                if (email != "eve.holt@reqres.in") {
                    showError("Unauthorized email format")
                    return@setOnClickListener
                }
                viewModel.register(email, password)
                registerButton.setOnClickListener {
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                }

                eyeIcon.setOnClickListener {
                    passwordField.transformationMethod =
                        if (passwordField.transformationMethod == null) {
                            android.text.method.PasswordTransformationMethod.getInstance()
                        } else {
                            null
                        }
                }
            }
        }
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}