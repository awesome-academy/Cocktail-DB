package com.sildev.thecocktail.data.di

import com.sildev.thecocktail.data.source.DiscoveryDataSource
import com.sildev.thecocktail.data.source.remote.DiscoveryDataRemoteSource
import org.koin.dsl.module

val DataSourceModule = module {
    single<DiscoveryDataSource.Remote> { DiscoveryDataRemoteSource(get()) }
}
