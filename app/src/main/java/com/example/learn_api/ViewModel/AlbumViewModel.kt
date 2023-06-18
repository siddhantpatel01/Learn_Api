package com.example.learn_api.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.learn_api.Repository.AlbumRepository
import com.example.learn_api.Response.AlbumResponse

class AlbumViewModel(private val albumRepository: AlbumRepository)  : ViewModel(){
    fun getAlbum():LiveData<AlbumResponse>{
        return  albumRepository.getAlbum()
    }
}