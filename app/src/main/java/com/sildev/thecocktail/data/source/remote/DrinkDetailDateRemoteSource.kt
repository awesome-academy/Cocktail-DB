package com.sildev.thecocktail.data.source.remote

import com.sildev.thecocktail.data.model.DrinkDetail
import com.sildev.thecocktail.data.source.DrinkDetailDataSource

class DrinkDetailDateRemoteSource(private val apiService: ApiService) :
    DrinkDetailDataSource.Remote {

    override suspend fun getDetailDrink(id: String): DrinkDetail =
        apiService.getDetailDrink(id).drinks.first()

}
