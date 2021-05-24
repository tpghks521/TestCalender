package com.example.mycalender.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.mycalender.R
import com.example.mycalender.adapter.viewholder.MonthViewHolder
import com.example.mycalender.data.CalenderData
import com.example.mycalender.data.Day
import com.example.mycalender.data.Memo
import com.example.mycalender.databinding.ViewDayBinding
import com.example.mycalender.viewmodels.MonthViewModel
import kotlinx.coroutines.withTimeout

class MonthAdapter(
    private val viewModel: MonthViewModel,
    private val position: Int?,
    private val lifecycleOwner: LifecycleOwner,
    private val clickListener: (Day) -> Unit
) :
    ListAdapter<Day, MonthViewHolder>(MothDiffCallback()) {

    init {
        position?.let {
            viewModel.getMemoList(position).observe(lifecycleOwner, Observer { memoList ->
                if (memoList.isNotEmpty()) {
                    var changeList: List<Day>? = null
                    memoList.forEach { memo ->

                        changeList = currentList.map { day ->
                            val date = "${day.dayOfYear}${day.dayOfMonth}"
                            if (date == memo.yearAndMont && memo.day == day.value) {

                                if (day.memo.isNullOrEmpty()) {
                                    val memoList = ArrayList<Memo>()
                                    memoList.add(memo)
                                    day.memo = memoList
                                } else {
                                    day.memo?.add(memo)
                                }
                            }
                            day
                        }
                    }
                    changeList?.let { list ->
                        Log.d("TestMemo", "submitList")
                        submitList(changeList)
                    }
                }
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthViewHolder {
        val binding: ViewDayBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.view_day, parent, false
        )
        return MonthViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: MonthViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

private class MothDiffCallback : DiffUtil.ItemCallback<Day>() {

    override fun areItemsTheSame(
        oldItem: Day,
        newItem: Day
    ): Boolean {
        return false
    }

    override fun areContentsTheSame(
        oldItem: Day,
        newItem: Day
    ): Boolean {
        return false
    }
}