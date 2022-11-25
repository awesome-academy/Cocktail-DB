package com.sildev.thecocktail.data.source.remote

import com.sildev.thecocktail.data.model.Category
import com.sildev.thecocktail.data.source.CategoryDataSource

class CategoryDataRemoteSource(private val apiService: ApiService) : CategoryDataSource.Remote {

    override suspend fun getCategory(): List<Category> = apiService.getCategory().categories
}
