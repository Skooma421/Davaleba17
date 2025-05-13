package com.example.davaleba17.network
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterApi {
    @POST("api/register")
    suspend fun register(@Body request: RegisterRequest): Response<RegisterResponse>
}

data class RegisterRequest(
    val email: String,
    val password: String
)

data class RegisterResponse(
    val id: Int? = null,
    val token: String? = null,
    val error: String? = null
)