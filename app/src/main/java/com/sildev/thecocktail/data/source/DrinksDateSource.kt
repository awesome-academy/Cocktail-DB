package com.sildev.thecocktail.data.source

import com.sildev.thecocktail.data.model.Drink

interface DrinksDateSource {

    interface Remote {
        suspend fun getDrinksByCategory(category: String): List<Drink>
        suspend fun getDrinksByIngredient(ingredient: String): List<Drink>
    }
}
