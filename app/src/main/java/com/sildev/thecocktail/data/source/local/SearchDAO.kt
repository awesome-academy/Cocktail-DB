package com.sildev.thecocktail.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sildev.thecocktail.data.model.Search

@Dao
interface SearchDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(search: Search)

    @Query("select * from ${DrinkDatabase.RECENT_SEARCH_TABLE}")
    suspend fun getSearchHistory(): List<Search>

    @Query("DELETE from ${DrinkDatabase.RECENT_SEARCH_TABLE}")
    suspend fun deleteAll()

}
