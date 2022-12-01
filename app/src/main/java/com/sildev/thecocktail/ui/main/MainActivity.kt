package com.sildev.thecocktail.ui.main

import android.content.Context
import android.content.ContextWrapper
import android.os.Bundle
import androidx.activity.viewModels
import com.sildev.thecocktail.R
import com.sildev.thecocktail.base.BaseActivity
import com.sildev.thecocktail.data.source.local.sharedpref.SharedPrefImplement
import com.sildev.thecocktail.data.source.local.sharedpref.SharedPrefKey
import com.sildev.thecocktail.databinding.ActivityMainBinding
import com.sildev.thecocktail.ui.viewpager.ViewPagerAdapter
import com.sildev.thecocktail.utils.extension.setAppLocale

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override val viewModel: MainViewModel by viewModels()
    private val listFragmentId =
        listOf(R.id.item_discovery, R.id.item_category, R.id.item_favourite, R.id.item_setting)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewPager.adapter = ViewPagerAdapter(this)
        binding.viewPager.isUserInputEnabled = false
        binding.navHome.setOnNavigationItemSelectedListener {
            binding.viewPager.currentItem = listFragmentId.indexOf(it.itemId)
            true
        }
        binding.navHome.setOnNavigationItemReselectedListener { }
    }


}
