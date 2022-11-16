package com.sildev.thecocktail.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

typealias Inflate<T> = (LayoutInflater) -> T

abstract class BaseActivity<T : ViewBinding>(private val inflater: Inflate<T>) :
    AppCompatActivity() {

    protected val binding: T by lazy { inflater(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

}
