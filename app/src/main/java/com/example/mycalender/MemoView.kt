package com.example.mycalender

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView

class MemoView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : androidx.appcompat.widget.AppCompatTextView(context, attrs, defStyleAttr) {

    fun setData(text: String) {
        this.text = text
    }
}