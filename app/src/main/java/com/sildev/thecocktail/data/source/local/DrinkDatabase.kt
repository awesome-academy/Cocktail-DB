package com.sildev.thecocktail.data.source.local

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.data.model.Search
import com.sildev.thecocktail.utils.Constant.ROOM_CURRENT_VERSION
import com.sildev.thecocktail.utils.Constant.ROOM_OLD_VERSION

@Database(
    entities = [Drink::class, Search::class],
    autoMigrations = [AutoMigration(from = ROOM_OLD_VERSION, to = ROOM_CURRENT_VERSION)],
    version = ROOM_CURRENT_VERSION,
    exportSchema = true
)
abstract class DrinkDatabase : RoomDatabase() {

    abstract fun getDrinkDAO(): DrinkDAO
    abstract fun getSearchDAO(): SearchDAO

    companion object {
        const val DATABASE_NAME = "DrinkDB"
        const val RECENT_SEARCH_TABLE = "recentSearch"
        const val FAVORITE_TABLE = "favoriteDrink"
    }
}
