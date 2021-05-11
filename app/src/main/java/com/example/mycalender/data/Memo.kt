package com.example.mycalender.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memo_table")
data class Memo(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var year: Int,
    var month: Int,
    var day: Int,
    var memo: String
)