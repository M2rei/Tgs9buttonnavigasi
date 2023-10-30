package com.example.tgs9buttonnavigasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.tgs9buttonnavigasi.databinding.ActivityPaymentBinding
import com.google.android.material.R

class PaymentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentBinding
    companion object{
        var jnsbioskop = ""
        var jnstiket = ""
        var jnspembayaran = ""
        var tanggal = ""
        var jam = ""
    }
    private val bioskopp = arrayOf(
        "Cinemaa XXI", "CGV", "Cinemaxx", "Independent", "New Star Cineplex","Platinum Cineplex"

    )
    private val jenistiket = arrayOf(
        "Tiket Biasa        :          Rp25.000",
        "Tiket VIP          :          Rp75.000",
        "Tiket 3D atau IMAX :          Rp125000",
    )
    private val jenispembayaran = arrayOf(
        "Pembayaran Kartu Kredit",
        "Gopay",
        "OVO",
        "Shoopeepay"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val username3 = intent.getStringExtra(LoginActivity.EXTRA_NAME)
        val film2 = intent.getParcelableExtra<Film>("film2")
        with(binding){
            val adapterType = ArrayAdapter(this@PaymentActivity, R.layout.support_simple_spinner_dropdown_item, bioskopp )
            val tiketadapter = ArrayAdapter(this@PaymentActivity, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, jenistiket )
            val pembayaran = ArrayAdapter(this@PaymentActivity, com.google.android.material.R.layout.support_simple_spinner_dropdown_item,jenispembayaran)
            adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerbioskop.adapter = adapterType

            tiketadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerjenistiket.adapter = tiketadapter

            pembayaran.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerjenispembayaran.adapter = pembayaran

            spinnerbioskop.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                    jnsbioskop = bioskopp[position]
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    jnsbioskop = bioskopp[0]
                }
            })
            spinnerjenistiket.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?,position: Int, id: Long) {
                    jnstiket = jenistiket[position]
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    jnstiket = jenistiket[0]
                }
            })
            spinnerjenispembayaran.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?,position: Int, id: Long) {
                    jnspembayaran = jenispembayaran[position]
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    jnspembayaran = jenispembayaran[0]
                }
            })
            // date picker
            dtpicker.init(
                dtpicker.year,
                dtpicker.month,
                dtpicker.dayOfMonth
            ){_, year, monthOfYear, dayOfMonth ->
                tanggal = "$dayOfMonth/${monthOfYear + 1}/$year"
            }
            // timepicker
            tmepicker.setOnTimeChangedListener{view, hourOfDay, minute ->
                jam = String.format("%02d:%02d", hourOfDay, minute)
            }
            // end timepicker

            // button listener
            btnpymorder.setOnClickListener(){
                val intentToorderActivity= Intent(this@PaymentActivity, OrderActivity::class.java)
                intentToorderActivity.putExtra(jnsbioskop, spinnerbioskop.selectedItem.toString())
                intentToorderActivity.putExtra( jnstiket, spinnerjenistiket.selectedItem.toString())
                intentToorderActivity.putExtra(jnspembayaran,spinnerjenispembayaran.selectedItem.toString())
                intentToorderActivity.putExtra("tanggal", tanggal)
                intentToorderActivity.putExtra("jam", jam)
                intentToorderActivity.putExtra(LoginActivity.EXTRA_NAME,username3)
                intentToorderActivity.putExtra("film3", film2)
                startActivity(intentToorderActivity)
            }
            btnpymback.setOnClickListener(){
                val intentTodetailActivity = Intent(this@PaymentActivity, DetailActivity::class.java)
                intentTodetailActivity.putExtra(LoginActivity.EXTRA_NAME,username3)
                startActivity(intentTodetailActivity)
            }
        }
    }

}