package com.sildev.thecocktail.data.repository

import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.data.model.Search
import com.sildev.thecocktail.utils.DataResult

interface SearchRepository {
    suspend fun suggestDrinkName(key: String): DataResult<List<Search>>
    suspend fun searchByName(key: String): DataResult<List<Drink>>
    suspend fun addSearchHistory(search: Search): DataResult<Unit>
    suspend fun deleteSearchHistory(): DataResult<Unit>
}
