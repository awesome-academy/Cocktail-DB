package com.sildev.thecocktail.data.repository

import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.utils.DataResult

interface FavouriteRepository {

    suspend fun getFavourites(): DataResult<List<Drink>>
}
