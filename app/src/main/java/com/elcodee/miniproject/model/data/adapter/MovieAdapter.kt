package com.elcodee.miniproject.model.data.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.elcodee.miniproject.databinding.ListItemBinding
import com.elcodee.miniproject.model.data.network.ApiService
import com.elcodee.miniproject.model.data.response.ApiResponse
import com.elcodee.miniproject.view.PostActivity
import com.elcodee.miniproject.view.PutActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            .centerCrop()
            .into(holder.binding.ivPoster)

        holder.binding.ivUpdate.setOnClickListener {
            val i = Intent(holder.itemView.context, PutActivity::class.java)
            i.putExtra("id", data.id)
            i.putExtra("na", data.nama_movie)
            i.putExtra("ge", data.genre)
            i.putExtra("pe", data.pemeran)
            i.putExtra("su", data.sutradara)
            i.putExtra("ne", data.negara)
            holder.itemView.context.startActivity(i)
        }

        holder.binding.ivDelete.setOnClickListener {
            ApiService.getInstance().deleteMovie(data.id).enqueue(object : Callback<ApiResponse>{
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    if (response.isSuccessful){
                        Toast.makeText(holder.itemView.context, "success", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(holder.itemView.context, "gagal", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    Toast.makeText(holder.itemView.context, "$t", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    override fun getItemCount() = listMovie.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<ApiResponse>){
        listMovie.clear()
        listMovie.addAll(data)
        notifyDataSetChanged()
    }
}