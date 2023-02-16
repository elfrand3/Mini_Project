package com.elcodee.miniproject.model.data.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.elcodee.miniproject.databinding.ListItemBinding
import com.elcodee.miniproject.model.data.response.ApiResponse

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.myviewHolder>() {
    private val listMovie = ArrayList<ApiResponse>()
    class myviewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return myviewHolder(binding)
    }

    override fun onBindViewHolder(holder: myviewHolder, position: Int) {
        val data = listMovie[position]
        holder.binding.tvId.text = data.id
        holder.binding.tvName.text = data.nama_movie
        holder.binding.tvGenre.text = data.genre
        holder.binding.tvPemeran.text = data.pemeran
        holder.binding.tvSutradara.text = data.sutradara
        holder.binding.tvNegara.text = data.negara
        holder.binding.tvDate.text = data.date
        Glide.with(holder.itemView.context)
            .load(data.poster)
            .into(holder.binding.ivPoster)
    }

    override fun getItemCount() = listMovie.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<ApiResponse>){
        listMovie.clear()
        listMovie.addAll(data)
        notifyDataSetChanged()
    }
}