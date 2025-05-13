package com.example.davaleba17

import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.davaleba17.databinding.FragmentRegisterBinding
import com.example.davaleba17.network.RegisterRequest
import com.example.davaleba17.network.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {
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
                register(email, password)
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

    private fun register(email: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val request = RegisterRequest(email, password)
                val response = RetrofitClient.RegisterApi.register(request)
            } catch (e: Exception) {
                d("error", "$e")
            }
        }
    }
}