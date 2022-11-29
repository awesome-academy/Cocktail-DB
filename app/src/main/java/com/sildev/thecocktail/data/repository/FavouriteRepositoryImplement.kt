package com.sildev.thecocktail.data.repository

import com.sildev.thecocktail.base.BaseRepository
import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.data.source.FavouriteDataSource
import com.sildev.thecocktail.utils.DataResult

class FavouriteRepositoryImplement(private val local: FavouriteDataSource.Local) :
    FavouriteRepository, BaseRepository() {

    override suspend fun getFavourites(): DataResult<List<Drink>> =
        getResult { local.getFavourite() }
}
