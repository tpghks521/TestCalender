package com.example.mycalender.data

import androidx.room.Entity
import androidx.room.PrimaryKey


data class Date(
    @PrimaryKey
    var id: Int = 0,
    var year: Int,
    var month: Int,
    var day: Int
)