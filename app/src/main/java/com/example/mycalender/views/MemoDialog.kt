package com.example.mycalender.views

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.mycalender.R
import com.example.mycalender.data.Date
import org.w3c.dom.Text

class MemoDialog(
    context: Context,
    private val date: Date,
    private val memoLisneter: (String) -> Unit
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

        year.text = date.year.toString()
        month.text = date.month.toString()
        day.text = date.day.toString()


        confirmButton.setOnClickListener {
            memoLisneter.invoke(editText.text.toString())
            dismiss()
        }

    }
}