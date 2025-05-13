package com.example.davaleba17.ViewModels

import android.util.Log.d
import androidx.lifecycle.ViewModel
import com.example.davaleba17.network.Models.RegisterRequest
import com.example.davaleba17.network.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistrationViewModel :ViewModel() {

     public fun register(email: String, password: String) {
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