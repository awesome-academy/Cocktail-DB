package com.sildev.thecocktail.data.source

import com.sildev.thecocktail.data.model.Drink

interface FavouriteDataSource {
    interface Local {
        suspend fun getFavourite(): List<Drink>
    }
}
