package com.example.mycalender.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.mycalender.R
import com.example.mycalender.adapter.viewholder.MonthViewHolder
import com.example.mycalender.data.Date
import com.example.mycalender.databinding.ViewDayBinding

class MonthAdapter(private val clickListener: (Date) -> Unit) :
    ListAdapter<Date, MonthViewHolder>(MothDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthViewHolder {
        val binding: ViewDayBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.view_day, parent, false
        )
        return MonthViewHolder(binding,clickListener)
    }

    override fun onBindViewHolder(holder: MonthViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

private class MothDiffCallback : DiffUtil.ItemCallback<Date>() {

    override fun areItemsTheSame(
        oldItem: Date,
        newItem: Date
    ): Boolean {
        return oldItem.day == newItem.day
    }

    override fun areContentsTheSame(
        oldItem: Date,
        newItem: Date
    ): Boolean {
        return oldItem == newItem
    }
}