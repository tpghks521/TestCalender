package com.example.mycalender.data

import androidx.room.Entity
import androidx.room.PrimaryKey


data class CalenderData(var year: Int, var month: Month)

data class Month(
    var value: Int,
    var day: ArrayList<Day>
)


data class Day(
    var dayOfYear: Int,
    var dayOfMonth: Int,
    var value: Int,
    var memo: ArrayList<Memo>? = null
)

@Entity(tableName = "memo_table")
data class Memo(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var yearAndMont: String,
    var day: Int,
    val text: String
)