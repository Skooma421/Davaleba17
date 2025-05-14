package com.example.davaleba17.network.api

import com.example.davaleba17.network.models.LoginRequest
import com.example.davaleba17.network.models.LoginResponse
import com.example.davaleba17.network.models.RegisterRequest
import com.example.davaleba17.network.models.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationApi {
    @POST("v3/ceaba753-9e6d-4ff2-bb4c-fe049f5948d0")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST("v3/8892db5a-64f7-488c-a8c8-371ae25bd2a2")
    suspend fun register(@Body request: RegisterRequest): Response<RegisterResponse>
}
