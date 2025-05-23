package com.example.davaleba17.network.retrofit

import com.example.davaleba17.network.api.AuthenticationApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://run.mocky.io/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val loginApi: AuthenticationApi by lazy {
        retrofit.create(AuthenticationApi::class.java)
    }

    val RegisterApi: AuthenticationApi by lazy{
        retrofit.create(RegisterApi::class.java)
    }
}