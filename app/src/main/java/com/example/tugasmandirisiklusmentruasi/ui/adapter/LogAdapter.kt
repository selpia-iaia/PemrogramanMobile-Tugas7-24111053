package com.example.tugasmandirisiklusmentruasi.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasmandirisiklusmentruasi.DailyLog
import com.example.tugasmandirisiklusmentruasi.R

class LogAdapter(private var logs: List<DailyLog>) : RecyclerView.Adapter<LogAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDate: TextView = view.findViewById(R.id.tvLogDate)
        val tvNote: TextView = view.findViewById(R.id.tvLogNote)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_log_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val log = logs[position]
        holder.tvDate.text = log.date
        holder.tvNote.text = log.note ?: "No notes"
    }

    override fun getItemCount() = logs.size

    fun updateData(newLogs: List<DailyLog>) {
        logs = newLogs
        notifyDataSetChanged()
    }
}
