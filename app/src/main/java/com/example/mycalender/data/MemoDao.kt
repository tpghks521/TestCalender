package com.example.mycalender.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MemoDao {

    @Insert
    fun insertMemo(memo: Memo)

//    @Query("SELECT year=:year,month=:month,day=:day  FROM memo_table")
//    fun getMemo(year: Int, month: Int, day: Int): List<Memo>

}