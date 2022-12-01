package com.sildev.thecocktail.data.di

import com.sildev.thecocktail.data.repository.DiscoveryRepository
import com.sildev.thecocktail.data.repository.DiscoveryRepositoryImplement
import com.sildev.thecocktail.data.repository.SearchRepository
import com.sildev.thecocktail.data.repository.SearchRepositoryImplement
import com.sildev.thecocktail.data.repository.CategoryRepository
import com.sildev.thecocktail.data.repository.CategoryRepositoryImplement
import com.sildev.thecocktail.data.repository.DrinksRepository
import com.sildev.thecocktail.data.repository.DrinksRepositoryImplement
import com.sildev.thecocktail.data.source.CategoryDataSource
import com.sildev.thecocktail.data.source.DiscoveryDataSource
import com.sildev.thecocktail.data.source.DrinksDateSource
import com.sildev.thecocktail.data.source.SearchDataSource
import com.sildev.thecocktail.data.source.SettingDataSource
import com.sildev.thecocktail.data.repository.DetailRepository
import com.sildev.thecocktail.data.repository.SettingRepository
import com.sildev.thecocktail.data.repository.SettingRepositoryImplement
import com.sildev.thecocktail.data.repository.FavouriteRepository
import com.sildev.thecocktail.data.repository.FavouriteRepositoryImplement
import com.sildev.thecocktail.data.repository.DetailRepositoryImplement
import com.sildev.thecocktail.data.source.DrinkDetailDataSource
import com.sildev.thecocktail.data.source.FavouriteDataSource

import org.koin.dsl.module

val RepositoryModule = module {
    single { provideDiscoveryRepository(get()) }
    single { provideSearchRepository(get(), get()) }
    single { provideCategoryRepository(get()) }
    single { provideDrinksRepository(get()) }
    single { provideDetailRepository(get(), get()) }
    single { provideFavouriteRepository(get()) }
    single { provideSettingRepository(get()) }
}

fun provideDiscoveryRepository(remote: DiscoveryDataSource.Remote): DiscoveryRepository {
    return DiscoveryRepositoryImplement(remote)
}

fun provideSearchRepository(
    local: SearchDataSource.Local, remote: SearchDataSource.Remote
): SearchRepository {
    return SearchRepositoryImplement(local, remote)
}

fun provideCategoryRepository(remote: CategoryDataSource.Remote): CategoryRepository {
    return CategoryRepositoryImplement(remote)
}

fun provideDrinksRepository(remote: DrinksDateSource.Remote): DrinksRepository {
    return DrinksRepositoryImplement(remote)
}

fun provideDetailRepository(
    local: DrinkDetailDataSource.Local, remote: DrinkDetailDataSource.Remote
): DetailRepository {
    return DetailRepositoryImplement(local, remote)
}

fun provideFavouriteRepository(local: FavouriteDataSource.Local): FavouriteRepository {
    return FavouriteRepositoryImplement(local)
}

fun provideSettingRepository(local: SettingDataSource.Local): SettingRepository {
    return SettingRepositoryImplement(local)
}
