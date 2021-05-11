package com.example.mycalender.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycalender.data.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MonthViewModel @Inject constructor(
    private var dateRepository: DateRepository, private val memoRepository: MemoRepository
) : ViewModel() {


    val dayList = MutableLiveData<List<Date>>()

    fun getDate(position: Int) {
        val dateList = dateRepository.getDate(position)
        dayList.postValue(dateList)
    }

    fun updateMemo(memo: Memo) = viewModelScope.launch {
        memoRepository.updateMemo(memo)
    }
}