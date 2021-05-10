package com.example.mycalender.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.mycalender.R
import com.example.mycalender.databinding.FragmentCalenderBinding

class CalenderFragment : Fragment() {

    lateinit var binding: FragmentCalenderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_calender, container, false)

       binding.tableRow.addMemo("테스트")

        return binding.root
    }
}