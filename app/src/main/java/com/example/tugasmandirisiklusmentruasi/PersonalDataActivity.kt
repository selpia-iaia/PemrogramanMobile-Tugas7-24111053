package com.example.tugasmandirisiklusmentruasi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasmandirisiklusmentruasi.databinding.ActivityPersonalDataBinding

class PersonalDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPersonalDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonalDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { finish() }
    }
}
