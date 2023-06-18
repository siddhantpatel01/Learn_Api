package com.example.learn_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learn_api.Adapter.AlbumAdapter
import com.example.learn_api.Factory.AlbumFactory
import com.example.learn_api.Repository.AlbumRepository
import com.example.learn_api.ViewModel.AlbumViewModel
import com.example.learn_api.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var factory: AlbumFactory
    lateinit var viewModel: AlbumViewModel
    lateinit var adapter: AlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the activity_main layout as the content view for this activity
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Initialize the AlbumFactory
        factory = AlbumFactory(AlbumRepository())

        // Create an instance of the AlbumViewModel using the ViewModelProvider
        viewModel = ViewModelProvider(this, factory)[AlbumViewModel::class.java]

        // Set the lifecycle owner of the binding to this activity
        binding.lifecycleOwner = this

        // Set up the RecyclerView with a LinearLayoutManager
        binding.rvApiData.layoutManager = LinearLayoutManager(this)

        // Observe the LiveData returned by the ViewModel's getAlbum() method
        viewModel.getAlbum().observe(this, Observer { albumList ->
            // Create an instance of the AlbumAdapter and pass the albumList
            adapter = AlbumAdapter(albumList)

            // Set the adapter for the RecyclerView
            binding.rvApiData.adapter = adapter

            // Notify the adapter that the dataset has changed
            adapter.notifyDataSetChanged()
        })
    }
}
