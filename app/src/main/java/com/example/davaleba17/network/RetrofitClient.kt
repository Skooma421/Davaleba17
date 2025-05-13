package com.example.davaleba17.network

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

    val loginApi: LoginApi by lazy {
        retrofit.create(LoginApi::class.java)
    }

    val RegisterApi: RegisterApi by lazy{
        retrofit.create(RegisterApi::class.java)
    }
}