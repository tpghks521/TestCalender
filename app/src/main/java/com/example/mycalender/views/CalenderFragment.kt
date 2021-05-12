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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalenderFragment : Fragment() {

    private lateinit var binding: FragmentCalenderBinding
    private lateinit var calenderAdapter: CalenderAdapter

    private val viewModel: CalenderViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_calender, container, false)
        setUpViewPager()
        setUpObserve()
        return binding.root
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
    
    private fun setUpObserve() {
        viewModel.currentYear.observe(viewLifecycleOwner, Observer { yaer ->
            binding.yaerTitle.text = yaer.toString()
        })
        viewModel.currentMonth.observe(viewLifecycleOwner, Observer { month ->
            binding.monthTitle.text = month.toString()
        })
    }
}