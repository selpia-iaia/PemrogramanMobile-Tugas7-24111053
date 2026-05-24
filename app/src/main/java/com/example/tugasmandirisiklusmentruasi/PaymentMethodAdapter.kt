package com.example.tugasmandirisiklusmentruasi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasmandirisiklusmentruasi.databinding.ItemPaymentMethodBinding

class PaymentMethodAdapter(
    private val items: List<PaymentMethod>,
    private val onItemClick: (PaymentMethod) -> Unit
) : RecyclerView.Adapter<PaymentMethodAdapter.ViewHolder>() {

    private var selectedPosition = -1

    inner class ViewHolder(val binding: ItemPaymentMethodBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPaymentMethodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.tvPaymentName.text = item.name
        holder.binding.ivPaymentIcon.setImageResource(item.iconRes)

        // Visual selection feedback
        if (selectedPosition == position) {
            holder.binding.root.setCardBackgroundColor(holder.itemView.context.getColor(R.color.pink_soft))
            holder.binding.root.strokeWidth = 4
            holder.binding.root.strokeColor = holder.itemView.context.getColor(R.color.pink_main)
        } else {
            holder.binding.root.setCardBackgroundColor(holder.itemView.context.getColor(R.color.white))
            holder.binding.root.strokeWidth = 0
        }

        holder.itemView.setOnClickListener {
            val previousSelected = selectedPosition
            selectedPosition = holder.adapterPosition
            notifyItemChanged(previousSelected)
            notifyItemChanged(selectedPosition)
            onItemClick(item)
        }
    }

    override fun getItemCount(): Int = items.size
}
