package com.example.tgs9buttonnavigasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tgs9buttonnavigasi.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    companion object{
        const val EXTRA_NAME = "extra_name"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding){
            btnlgn.setOnClickListener {
                val username = usernamelgn.text.toString()
                val password = passwordlgn.text.toString()
                if (username == "Muflih Raihan" && password == "22/503413/SV/21502"){
                    val intentTohomeActivity =
                        Intent(this@LoginActivity, MainActivity::class.java)
                    intentTohomeActivity.putExtra(EXTRA_NAME, usernamelgn.text.toString())
                    startActivity(intentTohomeActivity)
                }
                else{
                    Toast.makeText(this@LoginActivity, "Username atau Password salah", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}