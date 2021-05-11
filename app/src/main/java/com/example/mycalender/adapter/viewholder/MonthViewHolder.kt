package com.example.mycalender.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.mycalender.data.Date
import com.example.mycalender.databinding.ViewDayBinding

class MonthViewHolder(var binding: ViewDayBinding, var clickListener: (Date) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.setClickListener { view ->
            clickListener.invoke(binding.date!!)
        }
    }

    fun bind(date: Date) {
        binding.apply {
            this.date = date
            this.day = date.day.toString()
        }
    }
}