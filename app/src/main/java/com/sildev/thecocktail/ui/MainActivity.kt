package com.sildev.thecocktail.ui

import android.os.Bundle
import com.sildev.thecocktail.R
import com.sildev.thecocktail.base.BaseActivity
import com.sildev.thecocktail.databinding.ActivityMainBinding
import com.sildev.thecocktail.ui.category.CategoryFragment
import com.sildev.thecocktail.ui.discovery.DiscoveryFragment
import com.sildev.thecocktail.ui.favourite.FavouriteFragment
import com.sildev.thecocktail.ui.setting.SettingFragment
import com.sildev.thecocktail.utils.extension.replaceFragment

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragment(DiscoveryFragment())
        binding.navHome.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.item_category -> replaceFragment(CategoryFragment())
                R.id.item_discovery -> replaceFragment(DiscoveryFragment())
                R.id.item_favourite -> replaceFragment(FavouriteFragment())
                R.id.item_setting -> replaceFragment(SettingFragment())
            }
            true
        }
        binding.navHome.setOnItemReselectedListener {  }
    }

}
