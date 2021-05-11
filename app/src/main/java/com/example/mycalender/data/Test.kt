package com.example.mycalender.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class CalenderData(var year: Int? = null, var month: Month) : Parcelable

@Parcelize
data class Month(
    var month: Int? = null,
    var day: ArrayList<Int>? = null
) : Parcelable