package com.sildev.thecocktail.ui.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sildev.thecocktail.ui.category.CategoryFragment
import com.sildev.thecocktail.ui.discovery.DiscoveryFragment
import com.sildev.thecocktail.ui.favourite.FavouriteFragment
import com.sildev.thecocktail.ui.setting.SettingFragment
import org.koin.java.KoinJavaComponent.inject

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    private val listFragment = listOf<Fragment>(
        inject<DiscoveryFragment>(DiscoveryFragment::class.java).value,
        inject<CategoryFragment>(CategoryFragment::class.java).value,
        inject<FavouriteFragment>(FavouriteFragment::class.java).value,
        inject<SettingFragment>(SettingFragment::class.java).value
    )

    override fun getItemCount() = listFragment.size

    override fun createFragment(position: Int): Fragment {
        return listFragment[position]
    }
}
