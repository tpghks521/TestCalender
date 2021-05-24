package com.example.mycalender.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.mycalender.R
import com.example.mycalender.adapter.MonthAdapter
import com.example.mycalender.base.BaseFragment
import com.example.mycalender.data.CalenderData
import com.example.mycalender.data.Day
import com.example.mycalender.data.Memo
import com.example.mycalender.databinding.FragmentMonthBinding
import com.example.mycalender.viewmodels.MonthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MonthFragment : BaseFragment<FragmentMonthBinding, MonthViewModel>() {


    private lateinit var adapter: MonthAdapter
    override val viewModel: MonthViewModel by viewModels()
    private val position: Int? by lazy {
        arguments?.getInt("position")
    }

    override val layoutRes: Int
        get() = R.layout.fragment_month

    override fun subscribeUi() {
        setUpRecyclerView()
        setUpObserve()
        getDate()
    }

    private fun getDate() {
        position?.let { viewModel.getDate(it) }
    }

    private val clickListener: ((Day) -> Unit) = { date ->
        val dialog = MemoDialog(requireContext(), date) { memo ->
            viewModel.updateMemo(memo)
        }
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        );
        dialog.show()
    }

    private fun setUpRecyclerView() {
        adapter =
            MonthAdapter(
                viewModel = viewModel,
                clickListener = clickListener,
                position = position,
                lifecycleOwner = viewLifecycleOwner
            )
        binding.recyclerView.adapter = adapter
    }

    override fun setUpObserve() {
        viewModel.dayList.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

    companion object {
        fun newInstance(position: Int): Fragment {
            val args = Bundle()
            args.putInt("position", position)
            val fragment = MonthFragment()
            fragment.arguments = args
            return fragment
        }
    }


}