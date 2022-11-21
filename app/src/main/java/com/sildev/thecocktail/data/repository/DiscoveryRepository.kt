package com.sildev.thecocktail.data.repository

import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.data.model.DrinkResponse
import com.sildev.thecocktail.data.model.Ingredient
import com.sildev.thecocktail.utils.DataResult

interface DiscoveryRepository {

    suspend fun getRandomDrink(): DataResult<List<Drink>>
    suspend fun getIngredients(): DataResult<List<Ingredient>>
    suspend fun getCocktails(): DataResult<List<Drink>>
}
