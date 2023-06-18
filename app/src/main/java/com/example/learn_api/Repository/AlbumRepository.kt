package com.example.learn_api.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.learn_api.ApiService.RetrofitClient
import com.example.learn_api.Response.AlbumResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumRepository {
    val TAG = "AlbumRepository"
    var albumDataList: MutableLiveData<AlbumResponse> = MutableLiveData()

    fun getAlbum():LiveData<AlbumResponse>{
        val call = RetrofitClient.apiinterface.getAlbum()
        call.enqueue(object: Callback<AlbumResponse>{
            override fun onResponse(call: Call<AlbumResponse>, response: Response<AlbumResponse>) {
                if (response.isSuccessful){
                    val responseData =  response.body()
                    albumDataList.postValue(responseData!!)
                    Log.d(TAG, "onResponse: $responseData")
                }
            }

            override fun onFailure(call: Call<AlbumResponse>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }

        })
        return albumDataList
    }
}