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
        val month = calList[position].month.month
        month?.let {
            currentMonth.postValue(it)
        }
    }

    fun getDate(position: Int): List<Date> {
        val cal = calList[position]
        val dateList = ArrayList<Date>()
        cal.month.day?.forEach { day ->
            var yaer = cal.year!!
            var month = cal.month.month!!

            val date = when (day < 0) {
                true -> {
                    month -= 1
                    if (month <= 0) {
                        yaer -= 1
                        month = 12
                    }
                    Date(year = yaer, month = month, day = day * (-1))
                }
                false -> {
                    Date(year = yaer, month = month, day = day)
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

    private fun getDayList(year: Int, month: Int): ArrayList<Int> {
        val list = ArrayList<Int>()
        val calendar = getCalender(year, month)
        val end = calendar.getActualMaximum(Calendar.DATE)
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)

        addXDay(year, month, dayOfWeek, list)

        for (day in 1..end) {
            list.add(day)
        }

        return list
    }

    fun addXDay(year: Int, month: Int, dayOfWeek: Int, list: ArrayList<Int>) {
        var xMonth = month - 1
        var xYear = year
        if (xMonth < 0) {
            xYear = year - 1
            xMonth = 12
        }

        val calender = getCalender(xYear, xMonth)
        val end = calender.getActualMaximum(Calendar.DATE)

        for (i in end - dayOfWeek + 2..end) {
            list.add(i * (-1))
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