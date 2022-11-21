package com.sildev.thecocktail.data.di

import com.sildev.thecocktail.data.repository.DiscoveryRepository
import com.sildev.thecocktail.data.repository.DiscoveryRepositoryImplement
import com.sildev.thecocktail.data.source.DiscoveryDataSource
import org.koin.dsl.module

val RepositoryModule = module {
    single { provideDiscoveryRepository(get()) }
}

fun provideDiscoveryRepository(remote: DiscoveryDataSource.Remote): DiscoveryRepository {
    return DiscoveryRepositoryImplement(remote)
}
