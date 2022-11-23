package com.sildev.thecocktail.data.di

import com.sildev.thecocktail.data.source.DiscoveryDataSource
import com.sildev.thecocktail.data.source.SearchDataSource
import com.sildev.thecocktail.data.source.local.SearchDataLocalSource
import com.sildev.thecocktail.data.source.remote.DiscoveryDataRemoteSource
import com.sildev.thecocktail.data.source.remote.SearchDataRemoteSource
import org.koin.dsl.module

val DataSourceModule = module {
    single<DiscoveryDataSource.Remote> { DiscoveryDataRemoteSource(get()) }
    single<SearchDataSource.Local> { SearchDataLocalSource(get()) }
    single<SearchDataSource.Remote> { SearchDataRemoteSource(get()) }
}
