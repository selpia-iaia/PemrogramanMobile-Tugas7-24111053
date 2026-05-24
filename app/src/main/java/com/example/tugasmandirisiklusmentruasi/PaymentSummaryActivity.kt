package com.example.tugasmandirisiklusmentruasi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasmandirisiklusmentruasi.databinding.ActivityPaymentSummaryBinding

class PaymentSummaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentSummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentSummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { finish() }
        binding.btnConfirm.setOnClickListener {
            // Simulate processing then success
            startActivity(Intent(this, PaymentSuccessActivity::class.java))
            finish()
        }
    }
}
