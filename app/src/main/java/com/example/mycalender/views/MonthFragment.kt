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
import com.example.mycalender.data.Date
import com.example.mycalender.data.Memo
import com.example.mycalender.databinding.FragmentMonthBinding
import com.example.mycalender.viewmodels.MonthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MonthFragment : Fragment() {

    private lateinit var binding: FragmentMonthBinding
    private lateinit var adapter: MonthAdapter
    private val position: Int? by lazy {
        arguments?.getInt("position")
    }


    private val viewModel: MonthViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_month, container, false)

        setUpRecyclerView()
        setUpObserve()
        getDate()


        return binding.root
    }


    private fun getDate() {
        position?.let { viewModel.getDate(it) }
    }

    private val clickListener: ((Date) -> Unit) = { date ->
        val dialog = MemoDialog(requireContext(), date) { memo ->
            viewModel.updateMemo(
                Memo(
                    year = date.year,
                    month = date.month,
                    day = date.day,
                    memo = memo
                )
            )
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
        adapter = MonthAdapter(clickListener)
        binding.recyclerView.adapter = adapter
    }

    private fun setUpObserve() {
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