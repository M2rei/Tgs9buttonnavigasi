package com.example.tgs9buttonnavigasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.tgs9buttonnavigasi.databinding.ActivityOrderBinding

class OrderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOrderBinding
    private var tanggal: String? = null
    private var jam: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username4 = intent.getStringExtra(LoginActivity.EXTRA_NAME)
        val bbioskop = intent.getStringExtra(PaymentActivity.jnsbioskop)
        val tikett= intent.getStringExtra(PaymentActivity.jnstiket)
        val ppembayaran = intent.getStringExtra(PaymentActivity.jnspembayaran)
        val film3 = intent.getParcelableExtra<Film>("film3")
        if (film3 !=null){
            val textView : TextView = findViewById(R.id.text2)

            textView.text = film3.name

        }

        tanggal = intent.getStringExtra("tanggal")
        jam = intent.getStringExtra("jam")
        with(binding){
            text4.text = bbioskop
            text6.text = tikett
            text8.text = ppembayaran
            text10.text= "$tanggal"
            text12.text= "$jam"
            ussername.text = username4
        }
    }
}