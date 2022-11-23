package com.sildev.thecocktail.data.source.local

import com.sildev.thecocktail.data.model.Search
import com.sildev.thecocktail.data.source.SearchDataSource

class SearchDataLocalSource(private val searchDAO: SearchDAO) : SearchDataSource.Local {

    override suspend fun getSearchHistory(): List<Search> = searchDAO.getSearchHistory()
    override suspend fun addSearchHistory(search: Search) = searchDAO.insert(search)
    override suspend fun deleteSearchHistory() = searchDAO.deleteAll()

}
