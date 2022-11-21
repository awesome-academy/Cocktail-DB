package com.sildev.thecocktail.data.repository

import com.sildev.thecocktail.base.BaseRepository
import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.data.model.Ingredient
import com.sildev.thecocktail.data.source.DiscoveryDataSource
import com.sildev.thecocktail.utils.DataResult

class DiscoveryRepositoryImplement(private val remote: DiscoveryDataSource.Remote) :
    DiscoveryRepository, BaseRepository() {

    override suspend fun getRandomDrink(): DataResult<List<Drink>> = getResult {
        remote.getRandomDrink()
    }

    override suspend fun getIngredients(): DataResult<List<Ingredient>> = getResult {
        remote.getIngredients()
    }

    override suspend fun getCocktails(): DataResult<List<Drink>> = getResult {
        remote.getCocktails()
    }
}
