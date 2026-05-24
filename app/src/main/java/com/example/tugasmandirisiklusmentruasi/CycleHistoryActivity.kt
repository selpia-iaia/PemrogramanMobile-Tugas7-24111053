package com.example.tugasmandirisiklusmentruasi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasmandirisiklusmentruasi.databinding.ActivityCycleHistoryBinding

class CycleHistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCycleHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCycleHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}
