package com.example.tugasmandirisiklusmentruasi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasmandirisiklusmentruasi.databinding.ActivityPaymentMethodsBinding

class PaymentMethodsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentMethodsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentMethodsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { finish() }
        binding.btnNext.setOnClickListener {
            startActivity(Intent(this, PaymentSummaryActivity::class.java))
        }
    }
}
