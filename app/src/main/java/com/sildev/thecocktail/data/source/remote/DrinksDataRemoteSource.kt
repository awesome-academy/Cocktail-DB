package com.sildev.thecocktail.data.source.remote

import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.data.source.DrinksDateSource

class DrinksDataRemoteSource(private val apiService: ApiService) : DrinksDateSource.Remote {

    override suspend fun getDrinksByCategory(category: String): List<Drink> =
        apiService.filterByCategory(category).drinks


    override suspend fun getDrinksByIngredient(ingredient: String): List<Drink> =
        apiService.filterByIngredient(ingredient).drinks

}
