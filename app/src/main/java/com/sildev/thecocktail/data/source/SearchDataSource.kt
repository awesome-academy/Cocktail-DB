package com.sildev.thecocktail.data.source

import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.data.model.Search

interface SearchDataSource {
    interface Remote {
        suspend fun searchByName(key: String): List<Drink>
    }

    interface Local {
        suspend fun getSearchHistory(): List<Search>
        suspend fun addSearchHistory(search: Search)
        suspend fun deleteSearchHistory()
    }
}
