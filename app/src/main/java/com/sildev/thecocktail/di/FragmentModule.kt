package com.sildev.thecocktail.di

import com.sildev.thecocktail.ui.category.CategoryFragment
import com.sildev.thecocktail.ui.discovery.DiscoveryFragment
import com.sildev.thecocktail.ui.favourite.FavouriteFragment
import com.sildev.thecocktail.ui.setting.SettingFragment
import org.koin.dsl.module

val fragmentModule = module {
    single { DiscoveryFragment() }
    single { CategoryFragment() }
    single { FavouriteFragment() }
    single { SettingFragment() }
}
