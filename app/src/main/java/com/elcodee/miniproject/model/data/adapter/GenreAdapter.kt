package com.elcodee.miniproject.model.data.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elcodee.miniproject.databinding.ListGenreBinding
import com.elcodee.miniproject.model.data.response.GenreResponse

class GenreAdapter: RecyclerView.Adapter<GenreAdapter.myviewHolder>() {
    private val listGenre = ArrayList<GenreResponse>()
    class myviewHolder(val binding: ListGenreBinding): RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewHolder {
        val binding = ListGenreBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return myviewHolder(binding)
    }

    override fun onBindViewHolder(holder: myviewHolder, position: Int) {
        val data = listGenre[position]
        holder.binding.tvName.text = data.nama_genre
    }

    override fun getItemCount() = listGenre.size

    @SuppressLint("NotifyDataSetChanged")
    fun setGenre(data: List<GenreResponse>){
        listGenre.clear()
        listGenre.addAll(data)
        notifyDataSetChanged()
    }
}