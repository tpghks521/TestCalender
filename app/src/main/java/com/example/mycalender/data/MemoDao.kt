package com.example.mycalender.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import java.time.Year

@Dao
interface MemoDao {

    @Insert
    fun insertMemo(memo: Memo)

    @Query("SELECT * FROM memo_table where yearAndMont=:yearAndMonth")
    fun getMemoList(yearAndMonth: String): LiveData<List<Memo>>

}