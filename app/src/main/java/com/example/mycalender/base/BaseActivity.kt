package com.example.mycalender.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeDataBinding()
        observeViewModel()
    }

    abstract fun initializeDataBinding()
    abstract fun observeViewModel()
}


