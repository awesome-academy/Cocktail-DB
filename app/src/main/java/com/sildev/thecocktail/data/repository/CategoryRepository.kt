package com.sildev.thecocktail.data.repository

import com.sildev.thecocktail.data.model.Category
import com.sildev.thecocktail.utils.DataResult

interface CategoryRepository {
    suspend fun getCategory(): DataResult<List<Category>>
}
