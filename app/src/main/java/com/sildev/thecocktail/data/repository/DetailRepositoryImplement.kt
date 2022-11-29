package com.sildev.thecocktail.data.repository

import com.sildev.thecocktail.base.BaseRepository
import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.data.model.DrinkDetailCollapse
import com.sildev.thecocktail.data.source.DrinkDetailDataSource
import com.sildev.thecocktail.utils.DataResult

class DetailRepositoryImplement(
    private val local: DrinkDetailDataSource.Local, private val remote: DrinkDetailDataSource.Remote
) : DetailRepository, BaseRepository() {

    override suspend fun addToFavourite(drink: Drink): DataResult<Unit> =
        getResult { local.addToFavourite(drink) }

    override suspend fun deleteFromFavourite(drink: Drink): DataResult<Unit> =
        getResult { local.deleteFromFavourite(drink) }

    override suspend fun getDetailDrink(id: String): DataResult<DrinkDetailCollapse> =
        getResult { remote.getDetailDrink(id).mapToDrinkCollapse() }

    override suspend fun drinkIsFavourite(id: String): DataResult<Boolean> =
        getResult { local.findFavouriteById(id) }
}
