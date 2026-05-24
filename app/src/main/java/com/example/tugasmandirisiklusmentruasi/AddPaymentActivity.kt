package com.example.tugasmandirisiklusmentruasi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasmandirisiklusmentruasi.databinding.ActivityAddPaymentBinding

class AddPaymentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClose.setOnClickListener { finish() }
        binding.btnSave.setOnClickListener { finish() }
    }
}
