package com.sildev.thecocktail.data.repository

import com.sildev.thecocktail.base.BaseRepository
import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.data.source.DrinksDateSource
import com.sildev.thecocktail.utils.DataResult

class DrinksRepositoryImplement(private val remote: DrinksDateSource.Remote) : DrinksRepository,
    BaseRepository() {

    override suspend fun getDrinksByCategory(category: String): DataResult<List<Drink>> =
        getResult { remote.getDrinksByCategory(category) }


    override suspend fun getDrinksByIngredient(ingredient: String): DataResult<List<Drink>> =
        getResult { remote.getDrinksByIngredient(ingredient) }
}
