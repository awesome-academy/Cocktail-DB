package com.sildev.thecocktail.data.source.remote

import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.data.source.SearchDataSource

class SearchDataRemoteSource(private val apiService: ApiService) : SearchDataSource.Remote {

    override suspend fun searchByName(key: String): List<Drink> =
        apiService.getDrinkByName(key).drinks

}
