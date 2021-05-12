package com.example.mycalender.data

import javax.inject.Inject


class MemoRepository @Inject constructor(val database: AppDatabase) {


    fun updateMemo(memo: Memo) {
        database.memoDao().insertMemo(memo)
    }

    fun getMemoList(yearAndMonth: String) =
        database.memoDao().getMemoList(yearAndMonth)


}