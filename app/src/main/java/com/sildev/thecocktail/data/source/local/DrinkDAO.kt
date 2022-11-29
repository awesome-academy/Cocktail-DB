package com.sildev.thecocktail.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Delete

import com.sildev.thecocktail.data.model.Drink

@Dao
interface DrinkDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(drink: Drink)

    @Query("select * from ${DrinkDatabase.FAVORITE_TABLE}")
    suspend fun getFavoriteDrinks(): List<Drink>

    @Query("select * from ${DrinkDatabase.FAVORITE_TABLE} where idDrink=:id")
    suspend fun getFavouriteById(id: String): Drink?

    @Delete
    suspend fun deleteFavoriteDrink(drink: Drink)
}
