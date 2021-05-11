package com.example.mycalender.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.mycalender.data.Date
import com.example.mycalender.data.DateRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import java.text.FieldPosition
import javax.inject.Inject

@HiltViewModel
class CalenderViewModel @Inject constructor(private var dateRepository: DateRepository) :
    ViewModel() {
    fun getCalList() = dateRepository.calList

    val currentYear: LiveData<Int> = Transformations.map(dateRepository.currentYear) {
        return@map it
    }

    val currentMonth: LiveData<Int> = Transformations.map(dateRepository.currentMonth) {
        return@map it
    }


    fun setCurrentYear(position: Int) {
        dateRepository.setCurrentYear(position)
    }

    fun setCurrentMonth(position: Int) {
        dateRepository.setCurrentMonth(position)
    }

    fun getCurrentMonth() = dateRepository.currentMonth
    fun getCurrentYear() = dateRepository.currentYear


}