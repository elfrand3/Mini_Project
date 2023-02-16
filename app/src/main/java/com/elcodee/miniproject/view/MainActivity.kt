package com.elcodee.miniproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.elcodee.miniproject.R
import com.elcodee.miniproject.databinding.ActivityMainBinding
import com.elcodee.miniproject.model.contract.MainContract
import com.elcodee.miniproject.model.data.adapter.MovieAdapter
import com.elcodee.miniproject.model.data.response.ApiResponse
import com.elcodee.miniproject.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainContract.View {
    var adapter = MovieAdapter()
    private lateinit var presenter: MainPresenter
    private val binding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter = MainPresenter(this)
        presenter.getMovie()
    }

    override fun initActivity() {
        supportActionBar?.hide()
//        binding.rvMovie.layoutManager = LinearLayoutManager(this)
        binding.rvMovie.layoutManager = GridLayoutManager(this, 2)
        binding.rvMovie.adapter = adapter
    }

    override fun onMessage(Message: String) {
        Toast.makeText(this@MainActivity, Message, Toast.LENGTH_SHORT).show()
    }

    override fun setData(response: List<ApiResponse>) {
        val r = response
        adapter.setData(r)
    }
}