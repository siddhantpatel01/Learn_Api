package com.example.learn_api.ApiService

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val baseurl = "https://jsonplaceholder.typicode.com"

object RetrofitClient {

    private val retrofitClient: Retrofit.Builder by lazy {

        Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
    }
    val apiinterface: ApiService by lazy {
        retrofitClient.build().create(ApiService::class.java)
    }
}