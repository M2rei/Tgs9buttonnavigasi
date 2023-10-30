package com.example.tgs9buttonnavigasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.tgs9buttonnavigasi.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val username2 = intent.getStringExtra(LoginActivity.EXTRA_NAME)
        val film = intent.getParcelableExtra<Film>("film")
        if (film !=null){
            val textView : TextView = findViewById(R.id.detailedActivityTv)
            val imageView: ImageView = findViewById(R.id.imageview2)
            textView.text = film.name
            imageView.setImageResource(film.image)
        }
        with(binding){
            btndtlback.setOnClickListener(){
                val intentTohomeActivity = Intent(this@DetailActivity, HomeFragment::class.java)
                intentTohomeActivity.putExtra(LoginActivity.EXTRA_NAME, username2)
                startActivity(intentTohomeActivity)
            }
            btndtlget.setOnClickListener(){
                val intentTopaymentActivity = Intent(this@DetailActivity, PaymentActivity::class.java)
                intentTopaymentActivity.putExtra(LoginActivity.EXTRA_NAME, username2)
                intentTopaymentActivity.putExtra("film2",film)
                startActivity(intentTopaymentActivity)
            }
        }
    }
}