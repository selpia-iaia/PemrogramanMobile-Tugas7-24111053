package com.example.tugasmandirisiklusmentruasi.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugasmandirisiklusmentruasi.DatabaseHelper
import com.example.tugasmandirisiklusmentruasi.data.repository.CycleRepository
import com.example.tugasmandirisiklusmentruasi.databinding.ActivityLogListBinding
import com.example.tugasmandirisiklusmentruasi.ui.adapter.LogAdapter
import com.example.tugasmandirisiklusmentruasi.ui.viewmodel.CycleViewModel
import com.example.tugasmandirisiklusmentruasi.ui.viewmodel.CycleViewModelFactory

class LogListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogListBinding
    private val viewModel: CycleViewModel by viewModels {
        CycleViewModelFactory(CycleRepository(DatabaseHelper.getInstance(this)))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = LogAdapter(emptyList())
        binding.rvLogs.layoutManager = LinearLayoutManager(this)
        binding.rvLogs.adapter = adapter

        viewModel.dailyLogs.observe(this) { logs ->
            adapter.updateData(logs)
        }
    }
}
