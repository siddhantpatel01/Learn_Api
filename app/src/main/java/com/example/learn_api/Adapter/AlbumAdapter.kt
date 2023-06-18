package com.example.learn_api.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.learn_api.Model.AlbumItem
import com.example.learn_api.R
import com.example.learn_api.Response.AlbumResponse
import com.example.learn_api.databinding.ItemalbumBinding

class AlbumAdapter(private val albumData: List<AlbumItem>) :
    RecyclerView.Adapter<AlbumAdapter.MyViewHolder>() {

    inner class MyViewHolder(var binding: ItemalbumBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view: View? =
            LayoutInflater.from(parent.context).inflate(R.layout.itemalbum, parent, false)
        var binding: ItemalbumBinding = DataBindingUtil.bind(view!!)!!
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return albumData.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val album = albumData[position]
        holder.binding.apply {
            tvId.text = album.id.toString()
            tvUserId.text = album.userId.toString()
            tvTitle.text = album.title
        }
    }

}