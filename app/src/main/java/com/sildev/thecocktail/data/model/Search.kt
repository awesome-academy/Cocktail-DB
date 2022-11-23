package com.sildev.thecocktail.data.model

import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.sildev.thecocktail.data.source.local.DrinkDatabase

@Entity(
    tableName = DrinkDatabase.RECENT_SEARCH_TABLE
)
data class Search(
    @PrimaryKey
    @SerializedName("strDrink")
    val name: String
) {
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Search>() {
            override fun areItemsTheSame(oldItem: Search, newItem: Search) =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: Search, newItem: Search) = oldItem == newItem

        }
    }
}
