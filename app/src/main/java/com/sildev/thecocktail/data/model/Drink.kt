package com.sildev.thecocktail.data.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sildev.thecocktail.data.source.local.DrinkDatabase
import kotlinx.parcelize.Parcelize

@Entity(
    tableName = DrinkDatabase.FAVORITE_TABLE
)
@Parcelize
data class Drink(
    @PrimaryKey
    val idDrink: String,
    val strDrink: String,
    val strDrinkThumb: String,
) : Parcelable {

    companion object {

        val diffUtil = object : DiffUtil.ItemCallback<Drink>() {
            override fun areItemsTheSame(oldItem: Drink, newItem: Drink) =
                oldItem.idDrink == newItem.idDrink

            override fun areContentsTheSame(oldItem: Drink, newItem: Drink) = oldItem == newItem
        }
    }
}
