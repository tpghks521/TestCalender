package com.example.mycalender.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.mycalender.data.Day
import com.example.mycalender.databinding.ViewDayBinding

class MonthViewHolder(var binding: ViewDayBinding, var clickListener: (Day) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.setClickListener { view ->
            clickListener.invoke(binding.day!!)
        }
    }

    fun bind(day: Day) {
        binding.apply {
            this.day = day
        }
    }
}