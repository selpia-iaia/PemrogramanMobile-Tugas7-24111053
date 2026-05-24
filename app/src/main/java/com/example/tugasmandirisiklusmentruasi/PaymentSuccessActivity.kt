package com.example.tugasmandirisiklusmentruasi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasmandirisiklusmentruasi.databinding.ActivityPaymentSuccessBinding

class PaymentSuccessActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentSuccessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentSuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnExplore.setOnClickListener {
            finish()
        }
    }
}
