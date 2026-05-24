package com.example.tugasmandirisiklusmentruasi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasmandirisiklusmentruasi.databinding.ActivityBillingHistoryBinding

class BillingHistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBillingHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBillingHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { finish() }
        binding.btnAddPayment.setOnClickListener {
            startActivity(Intent(this, AddPaymentActivity::class.java))
        }
    }
}
