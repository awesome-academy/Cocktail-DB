package com.sildev.thecocktail.di

import com.sildev.thecocktail.ui.category.CategoryViewModel
import com.sildev.thecocktail.ui.discovery.DiscoveryViewModel
import com.sildev.thecocktail.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {
    viewModel { DiscoveryViewModel(get()) }
    viewModel { SearchViewModel(get()) }
    viewModel { CategoryViewModel(get()) }
}
