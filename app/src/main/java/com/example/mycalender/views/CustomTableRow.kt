package com.example.mycalender.views


import android.content.Context
import android.util.AttributeSet
import android.widget.TableRow
import com.example.mycalender.R


class CustomTableRow(context: Context, attrs: AttributeSet) : TableRow(context, attrs) {

    lateinit var sun: CustomDayView
 

    init {
        bindView()
    }

    private fun bindView() {
        val dayView = CustomDayView(context)
        this.addView(dayView)

    }

    fun addMemo(text: String) {
    }
}