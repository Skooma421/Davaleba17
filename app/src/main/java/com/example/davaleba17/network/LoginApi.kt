package com.example.davaleba17.network
import retrofit2.http.GET
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {
    @POST("v3/ceaba753-9e6d-4ff2-bb4c-fe049f5948d0")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}

data class LoginRequest(
    val email: String,
    val password: String
)

data class LoginResponse(
    val token: String? = null,
    val error: String? = null
)