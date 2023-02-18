package com.elcodee.miniproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.elcodee.miniproject.databinding.ActivityPostBinding
import com.elcodee.miniproject.model.contract.PostContract
import com.elcodee.miniproject.presenter.PostPresenter
import com.google.gson.JsonObject

class PostActivity : AppCompatActivity(), PostContract.View {
    private lateinit var presenter: PostPresenter
    private val binding: ActivityPostBinding by lazy {
        ActivityPostBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter = PostPresenter(this)
    }

    override fun initActivity() {
        supportActionBar?.hide()
    }

    override fun initListener() {
        binding.btnSave.setOnClickListener {
            val data = JsonObject()
            data.addProperty("nama_movie", binding.etNama.text.toString())
            data.addProperty("sutradara", binding.etSutradara.text.toString())
            data.addProperty("pemeran", binding.etPemeran.text.toString())
            data.addProperty("genre", binding.etGenre.text.toString())
            data.addProperty("negara", binding.etNegara.text.toString())
//            data.addProperty("date", binding.etDate.text.toString())
            presenter.postMovie(data)
        }
        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onMessage(Message: String) {
        Toast.makeText(this, Message, Toast.LENGTH_SHORT).show()
    }
}