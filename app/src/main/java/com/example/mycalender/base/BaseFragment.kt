package com.example.mycalender.base

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

abstract class BaseFragment<D : ViewDataBinding>() : Fragment() {

    protected abstract val layoutRes: Int

    lateinit var binding: D

//    val viewModel by lazy {
//        ViewModelProvider(viewModelStore,)
//    }

//    val viewModel: BaseViewModel by viewModels<>()
//
//    val viewModel2 : BaseViewModel by viewModels<> {
//
//    }


}