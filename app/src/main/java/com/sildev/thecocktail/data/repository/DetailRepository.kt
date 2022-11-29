package com.sildev.thecocktail.data.repository

import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.data.model.DrinkDetailCollapse
import com.sildev.thecocktail.utils.DataResult

interface DetailRepository {

    suspend fun addToFavourite(drink: Drink): DataResult<Unit>
    suspend fun deleteFromFavourite(drink: Drink): DataResult<Unit>
    suspend fun getDetailDrink(id: String): DataResult<DrinkDetailCollapse>
    suspend fun drinkIsFavourite(id: String): DataResult<Boolean>
}
