package com.example.mycalender.views

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

class CustomDayView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    fun addMemo(text: String) {
        val memoView = MemoView(context)
        memoView.setData(text)
        this.addView(memoView)
    }
}