package com.elcodee.miniproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.elcodee.miniproject.databinding.ActivityPostBinding

class PostActivity : AppCompatActivity() {
    private val binding: ActivityPostBinding by lazy {
        ActivityPostBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.hide()
        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }
}