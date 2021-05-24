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

abstract class BaseActivity<D : ViewDataBinding, V : BaseViewModel> :
    AppCompatActivity() {


    abstract val viewModel: V
    lateinit var binding: D
    protected abstract val layoutRes: Int

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        initializeDataBinding()
    }

    abstract fun initializeDataBinding()
}


