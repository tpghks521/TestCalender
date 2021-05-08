package com.example.mycalender


import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TableRow


class CustomTableRow(context: Context, attrs: AttributeSet) : TableRow(context, attrs) {

    lateinit var sunday: CustomDayView

    init {
        bindView()
    }

    private fun bindView() {
        val view = inflate(context, R.layout.view_custom_table_row, this)
        sunday = view.findViewById(R.id.sun)
    }

    fun addMemo(text: String) {
        sunday.addMemo(text)
    }
}