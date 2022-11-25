package com.sildev.thecocktail.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import com.sildev.thecocktail.R
import com.sildev.thecocktail.base.BaseActivity
import com.sildev.thecocktail.databinding.ActivityMainBinding
import com.sildev.thecocktail.ui.category.CategoryFragment
import com.sildev.thecocktail.ui.discovery.DiscoveryFragment
import com.sildev.thecocktail.ui.favourite.FavouriteFragment
import com.sildev.thecocktail.ui.setting.SettingFragment
import com.sildev.thecocktail.utils.extension.addFragment

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    override val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addFragment(R.id.fragment_container_home, DiscoveryFragment())
        binding.navHome.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.item_category -> addFragment(
                    R.id.fragment_container_home, CategoryFragment()
                )
                R.id.item_discovery -> addFragment(
                    R.id.fragment_container_home, DiscoveryFragment()
                )
                R.id.item_favourite -> addFragment(
                    R.id.fragment_container_home, FavouriteFragment()
                )
                R.id.item_setting -> addFragment(
                    R.id.fragment_container_home, SettingFragment()
                )
            }
            true
        }
        binding.navHome.setOnItemReselectedListener { }
    }

}
