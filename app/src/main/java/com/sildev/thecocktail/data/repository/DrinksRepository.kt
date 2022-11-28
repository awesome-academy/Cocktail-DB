package com.sildev.thecocktail.data.repository

import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.utils.DataResult

interface DrinksRepository {

    suspend fun getDrinksByCategory(category: String): DataResult<List<Drink>>
    suspend fun getDrinksByIngredient(ingredient: String): DataResult<List<Drink>>
}
