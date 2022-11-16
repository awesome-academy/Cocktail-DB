package com.sildev.thecocktail.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.utils.Constant

@Database(
    entities = [Drink::class], version = Constant.ROOM_VERSION
)
@TypeConverters(ListConverter::class)
abstract class DrinkDatabase : RoomDatabase() {

    abstract fun getDrinkDAO(): DrinkDAO

    companion object {
        const val DATABASE_NAME = "DrinkDB"
        const val RECENT_SEARCH_TABLE = "recentSearch"
        const val FAVORITE_TABLE = "favorite"
    }
}
