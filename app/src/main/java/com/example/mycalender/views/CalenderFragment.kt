package com.example.mycalender.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.mycalender.R
import com.example.mycalender.adapter.CalenderAdapter
import com.example.mycalender.databinding.FragmentCalenderBinding
import com.example.mycalender.viewmodels.CalenderViewModel
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.example.mycalender.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalenderFragment : BaseFragment<FragmentCalenderBinding, CalenderViewModel>() {


    private lateinit var calenderAdapter: CalenderAdapter

    override val viewModel: CalenderViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.fragment_calender

    override fun subscribeUi() {
        setUpViewPager()
        setUpObserve()
    }

    private fun setUpViewPager() {
        calenderAdapter = CalenderAdapter(viewModel, this)

        binding.apply {
            viewPager.adapter = calenderAdapter
            viewPager.offscreenPageLimit = 3
        }

        binding.viewPager.post {
            binding.viewPager.currentItem = 1470
        }

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                viewModel.setCurrentMonth(position = position)
                viewModel.setCurrentYear(position = position)
            }
        })
    }

    override fun setUpObserve() {
        viewModel.currentYear.observe(viewLifecycleOwner, Observer { yaer ->
            binding.yaerTitle.text = yaer.toString()
        })
        viewModel.currentMonth.observe(viewLifecycleOwner, Observer { month ->
            binding.monthTitle.text = month.toString()
        })
    }


}