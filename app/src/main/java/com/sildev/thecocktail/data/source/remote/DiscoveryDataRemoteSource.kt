package com.sildev.thecocktail.data.source.remote

import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.data.model.Ingredient
import com.sildev.thecocktail.data.source.DiscoveryDataSource

class DiscoveryDataRemoteSource(private val apiService: ApiService) : DiscoveryDataSource.Remote {

    override suspend fun getRandomDrink(): List<Drink> {
        return apiService.getRandomDrink().drinks
    }

    override suspend fun getIngredients(): List<Ingredient> {
        return apiService.getListIngredient().ingredients
    }

    override suspend fun getCocktails(): List<Drink> {
        return apiService.getCockTailDrink().drinks
    }
}
