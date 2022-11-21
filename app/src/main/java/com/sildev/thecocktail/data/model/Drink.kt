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
    @PrimaryKey val idDrink: String,
    val strDrink: String,
    val strDrinkAlternate: String,
    val strCategory: String,
    val strAlcoholic: String,
    val strInstructions: String,
    val strDrinkThumb: String,
    val strIngredient1: String,
    val strIngredient2: String,
    val strIngredient3: String,
    val strIngredient4: String,
    val strIngredient5: String,
    val strMeasure1: String,
    val strMeasure2: String,
    val strMeasure3: String,
    val strMeasure4: String,
    val strMeasure5: String,
    val dateModified: String
) : Parcelable {

    companion object {

        val diffUtil = object : DiffUtil.ItemCallback<Drink>() {
            override fun areItemsTheSame(oldItem: Drink, newItem: Drink) =
                oldItem.idDrink == newItem.idDrink

            override fun areContentsTheSame(oldItem: Drink, newItem: Drink) = oldItem == newItem
        }
    }
}
