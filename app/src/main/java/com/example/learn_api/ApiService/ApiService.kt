package com.example.learn_api.ApiService

import com.example.learn_api.Response.AlbumResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/albums")
    fun getAlbum(): Call<AlbumResponse>

}