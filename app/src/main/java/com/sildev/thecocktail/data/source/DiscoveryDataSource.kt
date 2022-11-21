package com.sildev.thecocktail.data.source

import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.data.model.Ingredient

interface DiscoveryDataSource {
    interface Remote {
        suspend fun getRandomDrink(): List<Drink>
        suspend fun getIngredients(): List<Ingredient>
        suspend fun getCocktails(): List<Drink>
    }
}
