package com.example.mycalender

import android.app.Activity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mycalender.base.BaseActivity
import com.example.mycalender.databinding.ActivityMainBinding
import com.example.mycalender.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.databinding.DataBindingUtil.setContentView

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun initializeDataBinding() {
        setContentView<ActivityMainBinding>(this, R.layout.activity_main)

    }

    override fun observeViewModel() {
    }

}