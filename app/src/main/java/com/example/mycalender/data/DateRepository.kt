package com.example.mycalender.data

import androidx.lifecycle.MutableLiveData
import java.util.Calendar
import javax.inject.Inject

class DateRepository @Inject constructor() {

    val currentYear = MutableLiveData<Int>()
    val currentMonth = MutableLiveData<Int>()

    init {
        setCalendarData()
    }

    lateinit var calList: ArrayList<CalenderData>


    fun setCurrentYear(position: Int) {
        if (position < 0) {
            return
        }
        val year = calList[position].year
        year?.let {
            currentYear.postValue(it)
        }
    }

    fun setCurrentMonth(position: Int) {
        if (position < 0) {
            return
        }
        val month = calList[position].month.value
        month?.let {
            currentMonth.postValue(it)
        }
    }

    fun getYear(position: Int): Int {
        val cal = calList[position]
        return cal.year
    }

    fun getMonth(position: Int): Int {
        val cal = calList[position]
        return cal.month.value
    }

    fun getDayList(position: Int): List<Day> {
        val cal = calList[position]
        val dateList = ArrayList<Day>()

        cal.month.day.forEach { day ->
            var yaer = cal.year
            var month = cal.month.value

            val date = when (day.value < 0) {
                true -> {
                    month -= 1
                    if (month <= 0) {
                        yaer -= 1
                        month = 12
                    }
                    Day(dayOfYear = yaer, dayOfMonth = month, value = day.value * (-1))
                }
                false -> {
                    Day(dayOfYear = yaer, dayOfMonth = month, value = day.value)
                }
            }
            dateList.add(date)
        }
        return dateList
    }


    private fun setCalendarData() {
        calList = ArrayList<CalenderData>()
        for (i in 1900..2100) {
            for (j in 1..12) {
                val date = CalenderData(i, getMonth(i, j))
                calList.add(date)
            }
        }
    }

    private fun getMonth(year: Int, month: Int): Month {
        val dayList = getDayList(year, month)
        return Month(month, dayList)
    }

    private fun getDayList(year: Int, month: Int): ArrayList<Day> {
        val list = ArrayList<Day>()
        val calendar = getCalender(year, month)
        val end = calendar.getActualMaximum(Calendar.DATE)
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)

        addXDay(year, month, dayOfWeek, list)

        for (day in 1..end) {
            val day = Day(dayOfYear = year, dayOfMonth = month, day)
            list.add(day)
        }

        return list
    }

    private fun addXDay(year: Int, month: Int, dayOfWeek: Int, list: ArrayList<Day>) {
        var xMonth = month - 1
        var xYear = year
        if (xMonth < 0) {
            xYear = year - 1
            xMonth = 12
        }

        val calender = getCalender(xYear, xMonth)
        val end = calender.getActualMaximum(Calendar.DATE)

        for (i in end - dayOfWeek + 2..end) {
            val day = Day(dayOfYear = xYear, dayOfMonth = xMonth, value = i * (-1))
            list.add(day)
        }
    }

    private fun getCalender(year: Int, month: Int): Calendar {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(year, month - 1, 1)
        return calendar
    }
}