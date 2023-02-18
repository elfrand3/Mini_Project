package com.elcodee.miniproject.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.elcodee.miniproject.R
import com.elcodee.miniproject.databinding.ActivityMainBinding
import com.elcodee.miniproject.model.contract.MainContract
import com.elcodee.miniproject.model.data.adapter.GenreAdapter
import com.elcodee.miniproject.model.data.adapter.MovieAdapter
import com.elcodee.miniproject.model.data.response.ApiResponse
import com.elcodee.miniproject.model.data.response.GenreResponse
import com.elcodee.miniproject.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainContract.View {
    var adapter = MovieAdapter()
    var genreAdapter = GenreAdapter()
    private lateinit var presenter: MainPresenter
    private val binding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter = MainPresenter(this)
        presenter.getMovie()
        presenter.getGenre()
    }

    override fun initActivity() {
        supportActionBar?.hide()
        binding.rvMovie.layoutManager = GridLayoutManager(this, 2)
        binding.rvGenre.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvMovie.adapter = adapter
        binding.rvGenre.adapter = genreAdapter
    }

    override fun initListener() {
        binding.fbAdd.setOnClickListener {
            startActivity(Intent(this@MainActivity, PostActivity::class.java))
        }
    }

    override fun onMessage(Message: String) {
        Toast.makeText(this@MainActivity, Message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoading(loading: Boolean) {
        binding.slRefresh.isRefreshing = loading
    }

    override fun setData(response: List<ApiResponse>) {
        val r = response
        adapter.setData(r)
    }

    override fun setGenre(genre: List<GenreResponse>) {
        val g = genre
        genreAdapter.setGenre(g)

    }
}