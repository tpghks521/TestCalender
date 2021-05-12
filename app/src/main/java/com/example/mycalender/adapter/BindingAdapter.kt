package com.example.mycalender.adapter

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.mycalender.data.Day

@BindingAdapter("date")
fun bindDate(view: TextView, date: Int) {
    view.text = date.toString()
}

@BindingAdapter("memo")
fun bindDate(view: TextView, day: Day) {
    if (!day.memo.isNullOrEmpty()) {
        view.text = day.memo!!.get(0).text
    }

}