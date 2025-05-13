package com.example.davaleba17.network
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterApi {
    @POST("v3/8892db5a-64f7-488c-a8c8-371ae25bd2a2")
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