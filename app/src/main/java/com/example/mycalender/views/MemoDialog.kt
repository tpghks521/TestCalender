package com.example.mycalender.views

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.mycalender.R
import com.example.mycalender.data.CalenderData
import com.example.mycalender.data.Day
import com.example.mycalender.data.Memo

class MemoDialog(
    context: Context,
    private val date: Day,
    private val memoLisneter: (Memo) -> Unit
) :
    Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_dialog)

        val year: TextView = findViewById(R.id.year)
        val month: TextView = findViewById(R.id.month)
        val day: TextView = findViewById(R.id.day)
        val editText: EditText = findViewById(R.id.edit_text)
        val confirmButton: Button = findViewById(R.id.button)

        year.text = date.dayOfYear.toString()
        month.text = date.dayOfMonth.toString()
        day.text = date.value.toString()


        confirmButton.setOnClickListener {
            val text = editText.text.toString()
            val yearAndMonth = "${date.dayOfYear}${date.dayOfMonth}"
            val memo = Memo(yearAndMont = yearAndMonth, text = text, day = date.value)
            memoLisneter.invoke(memo)
            dismiss()
        }

    }
}