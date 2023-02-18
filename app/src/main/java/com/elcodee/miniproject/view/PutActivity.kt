package com.elcodee.miniproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.elcodee.miniproject.databinding.ActivityPutBinding
import com.elcodee.miniproject.model.contract.PutContract
import com.elcodee.miniproject.presenter.PutPresenter
import com.google.gson.JsonObject

class PutActivity : AppCompatActivity(), PutContract.View {
    var id:String? = ""
    private lateinit var presenter: PutPresenter
    private val binding: ActivityPutBinding by lazy {
        ActivityPutBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter = PutPresenter(this)
    }

    override fun initActivity() {
        supportActionBar?.hide()
        val i = intent
        id = i.getStringExtra("id")
        binding.etNama.setText(i.getStringExtra("na"))
        binding.etGenre.setText(i.getStringExtra("ge"))
        binding.etPemeran.setText(i.getStringExtra("pe"))
        binding.etSutradara.setText(i.getStringExtra("su"))
        binding.etNegara.setText(i.getStringExtra("ne"))
    }

    override fun initListener() {
        binding.btnUpdate.setOnClickListener {
            val up = JsonObject()
            up.addProperty("nama_movie", binding.etNama.text.toString())
            up.addProperty("sutradara", binding.etSutradara.text.toString())
            up.addProperty("pemeran", binding.etPemeran.text.toString())
            up.addProperty("genre", binding.etGenre.text.toString())
            up.addProperty("negara", binding.etNegara.text.toString())
//            data.addProperty("date", binding.etDate.text.toString())
            presenter.putMovie(id.toString(),up)
            finish()
        }
        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onMessage(Message: String) {
        Toast.makeText(this@PutActivity, "$Message", Toast.LENGTH_SHORT).show()
    }
}