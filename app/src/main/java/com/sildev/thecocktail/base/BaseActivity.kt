package com.sildev.thecocktail.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.sildev.thecocktail.utils.extension.showToast

typealias Inflate<T> = (LayoutInflater) -> T

abstract class BaseActivity<T : ViewBinding>(private val inflater: Inflate<T>) :
    AppCompatActivity() {

    protected val binding: T by lazy { inflater(layoutInflater) }
    abstract val viewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.error.observe(this) {
            showToast(it)
        }
    }

}
