package com.sildev.thecocktail.data.repository

import com.sildev.thecocktail.base.BaseRepository
import com.sildev.thecocktail.data.model.Category
import com.sildev.thecocktail.data.source.CategoryDataSource
import com.sildev.thecocktail.utils.DataResult

class CategoryRepositoryImplement(private val remote: CategoryDataSource.Remote) :
    CategoryRepository, BaseRepository() {

    override suspend fun getCategory(): DataResult<List<Category>> =
        getResult { remote.getCategory() }
}
