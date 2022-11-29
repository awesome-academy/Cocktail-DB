package com.sildev.thecocktail.data.source

import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.data.model.DrinkDetail

interface DrinkDetailDataSource {
    interface Local {
        suspend fun addToFavourite(drink: Drink)
        suspend fun deleteFromFavourite(drink: Drink)
        suspend fun findFavouriteById(id: String): Boolean
    }

    interface Remote {
        suspend fun getDetailDrink(id: String): DrinkDetail
    }
}
