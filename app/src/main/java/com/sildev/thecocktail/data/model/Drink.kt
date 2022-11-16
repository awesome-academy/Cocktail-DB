package com.sildev.thecocktail.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sildev.thecocktail.data.source.local.DrinkDatabase

@Entity(
    tableName = DrinkDatabase.FAVORITE_TABLE
)
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
)
