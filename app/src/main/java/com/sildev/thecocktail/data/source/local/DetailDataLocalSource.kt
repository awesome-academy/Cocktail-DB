package com.sildev.thecocktail.data.source.local

import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.data.source.DrinkDetailDataSource

class DetailDataLocalSource(private val drinkDAO: DrinkDAO) : DrinkDetailDataSource.Local {
    override suspend fun addToFavourite(drink: Drink) = drinkDAO.insert(drink)


    override suspend fun deleteFromFavourite(drink: Drink) = drinkDAO.deleteFavoriteDrink(drink)

    override suspend fun findFavouriteById(id: String): Boolean {
        drinkDAO.getFavouriteById(id) ?: return false
        return true
    }
}
