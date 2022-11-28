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
import org.koin.dsl.module

val RepositoryModule = module {
    single { provideDiscoveryRepository(get()) }
    single { provideSearchRepository(get(), get()) }
    single { provideCategoryRepository(get()) }
    single { provideDrinksRepository(get()) }
}

fun provideDiscoveryRepository(remote: DiscoveryDataSource.Remote): DiscoveryRepository {
    return DiscoveryRepositoryImplement(remote)
}

fun provideSearchRepository(
    local: SearchDataSource.Local,
    remote: SearchDataSource.Remote
): SearchRepository {
    return SearchRepositoryImplement(local, remote)
}

fun provideCategoryRepository(remote: CategoryDataSource.Remote): CategoryRepository {
    return CategoryRepositoryImplement(remote)
}

fun provideDrinksRepository(remote: DrinksDateSource.Remote): DrinksRepository {
    return DrinksRepositoryImplement(remote)
}
