package com.sildev.thecocktail.data.repository

import com.sildev.thecocktail.base.BaseRepository
import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.data.model.Search
import com.sildev.thecocktail.data.source.SearchDataSource
import com.sildev.thecocktail.utils.DataResult

class SearchRepositoryImplement(
    val local: SearchDataSource.Local, val remote: SearchDataSource.Remote
) : SearchRepository, BaseRepository() {

    override suspend fun suggestDrinkName(key: String): DataResult<List<Search>> {
        val listResult = mutableListOf<Search>()
        val searchHistory = local.getSearchHistory().reversed()
        listResult.addAll(searchHistory.filter { it.name.contains(key, true) })
        if (key.isNotBlank()) {
            val list = remote.searchByName(key)
            if (list != null) {
                listResult.addAll(list.map { Search(it.strDrink) })
            }
        }
        return getResult { listResult }
    }

    override suspend fun searchByName(key: String): DataResult<List<Drink>> =
        getResult { remote.searchByName(key) }

    override suspend fun addSearchHistory(search: Search) =
        getResult { local.addSearchHistory(search) }

    override suspend fun deleteSearchHistory(): DataResult<Unit> =
        getResult { local.deleteSearchHistory() }

}
