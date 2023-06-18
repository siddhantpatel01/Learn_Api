package com.example.learn_api.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.learn_api.Repository.AlbumRepository
import com.example.learn_api.ViewModel.AlbumViewModel

class AlbumFactory(private val albumRepository: AlbumRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlbumViewModel::class.java)){
            return AlbumViewModel(albumRepository) as T
        }
        throw IllegalArgumentException("Unknown class")
    }
}