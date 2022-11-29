package com.sildev.thecocktail.data.source.local

import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.data.source.FavouriteDataSource

class FavouriteDataLocalSource(private val drinkDAO: DrinkDAO) : FavouriteDataSource.Local {

    override suspend fun getFavourite(): List<Drink> = drinkDAO.getFavoriteDrinks()
}
