package com.example.mycalender.adapter

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder
import com.example.mycalender.viewmodels.CalenderViewModel
import com.example.mycalender.views.MonthFragment

class CalenderAdapter(private val viewModel: CalenderViewModel, fragment: Fragment) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return viewModel.getCalList().size
    }

    override fun createFragment(position: Int): Fragment {
        return MonthFragment.newInstance(position)
    }
}