package com.example.mycalender


import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TableRow


class CustomTableRow(context: Context, attrs: AttributeSet) : TableRow(context, attrs) {

    lateinit var sun: CustomDayView
    lateinit var mon: CustomDayView
    lateinit var tue: CustomDayView
    lateinit var wed: CustomDayView
    lateinit var thu: CustomDayView
    lateinit var fri: CustomDayView
    lateinit var sat: CustomDayView

    init {
        bindView()
    }

    private fun bindView() {
        val view = inflate(context, R.layout.view_custom_table_row, this)
        sun = view.findViewById(R.id.sun)
        mon = view.findViewById(R.id.mon)
        tue = view.findViewById(R.id.tue)
        wed = view.findViewById(R.id.wed)
        thu = view.findViewById(R.id.thu)
        fri = view.findViewById(R.id.fri)
        sat = view.findViewById(R.id.sat)
    }

    fun addMemo(text: String) {
        sun.addMemo(text)
        mon.addMemo(text)
        tue.addMemo(text)
        wed.addMemo(text)
        thu.addMemo(text)
        fri.addMemo(text)
        sat.addMemo(text)
    }
}