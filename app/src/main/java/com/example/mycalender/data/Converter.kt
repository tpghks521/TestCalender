package com.example.mycalender.data

import androidx.room.TypeConverter
import java.util.*

class Converter {

    @TypeConverter
    fun MonthToJson(calendar: Calendar): Long = calendar.timeInMillis

    @TypeConverter
    fun datestampToCalendar(value: Long): Calendar =
        Calendar.getInstance().apply { timeInMillis = value }
}