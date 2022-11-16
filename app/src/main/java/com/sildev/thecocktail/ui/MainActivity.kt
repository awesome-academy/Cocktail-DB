package com.sildev.thecocktail.ui

import android.os.Bundle
import com.sildev.thecocktail.base.BaseActivity
import com.sildev.thecocktail.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}
