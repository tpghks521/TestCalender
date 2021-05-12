package com.example.mycalender.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycalender.data.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MonthViewModel @Inject constructor(
    private var dateRepository: DateRepository, private val memoRepository: MemoRepository
) : ViewModel() {


    val dayList = MutableLiveData<List<Day>>()

    fun getDate(position: Int) {
        val dateList = dateRepository.getDayList(position)
        dayList.postValue(dateList)
    }

    fun getMemoList(position: Int): LiveData<List<Memo>> {
        val yearAndMonth = "${getYear(position)}${getMonth(position)}"
        return memoRepository.getMemoList(yearAndMonth)
    }

    private fun getMonth(position: Int) = dateRepository.getMonth(position)
    private fun getYear(position: Int) = dateRepository.getYear(position)


    fun updateMemo(memo: Memo) = viewModelScope.launch(Dispatchers.IO) {
        memoRepository.updateMemo(memo)
    }
}