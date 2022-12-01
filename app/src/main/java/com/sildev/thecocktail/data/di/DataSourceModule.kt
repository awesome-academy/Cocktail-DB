package com.sildev.thecocktail.data.di

import com.sildev.thecocktail.data.source.DrinkDetailDataSource
import com.sildev.thecocktail.data.source.FavouriteDataSource
import com.sildev.thecocktail.data.source.SettingDataSource
import com.sildev.thecocktail.data.source.local.DetailDataLocalSource
import com.sildev.thecocktail.data.source.CategoryDataSource
import com.sildev.thecocktail.data.source.DiscoveryDataSource
import com.sildev.thecocktail.data.source.DrinksDateSource
import com.sildev.thecocktail.data.source.SearchDataSource
import com.sildev.thecocktail.data.source.local.FavouriteDataLocalSource
import com.sildev.thecocktail.data.source.local.SearchDataLocalSource
import com.sildev.thecocktail.data.source.local.SettingDataLocalSource
import com.sildev.thecocktail.data.source.remote.DrinkDetailDateRemoteSource
import com.sildev.thecocktail.data.source.remote.CategoryDataRemoteSource
import com.sildev.thecocktail.data.source.remote.DiscoveryDataRemoteSource
import com.sildev.thecocktail.data.source.remote.DrinksDataRemoteSource
import com.sildev.thecocktail.data.source.remote.SearchDataRemoteSource
import org.koin.dsl.module

val DataSourceModule = module {
    single<DiscoveryDataSource.Remote> { DiscoveryDataRemoteSource(get()) }
    single<SearchDataSource.Local> { SearchDataLocalSource(get()) }
    single<SearchDataSource.Remote> { SearchDataRemoteSource(get()) }
    single<CategoryDataSource.Remote> { CategoryDataRemoteSource(get()) }
    single<DrinksDateSource.Remote> { DrinksDataRemoteSource(get()) }
    single<DrinkDetailDataSource.Remote> { DrinkDetailDateRemoteSource(get()) }
    single<DrinkDetailDataSource.Local> { DetailDataLocalSource(get()) }
    single<FavouriteDataSource.Local> { FavouriteDataLocalSource(get()) }
    single<SettingDataSource.Local> { SettingDataLocalSource(get()) }
}
