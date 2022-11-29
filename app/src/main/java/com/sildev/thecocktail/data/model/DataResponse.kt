package com.sildev.thecocktail.data.model

import com.google.gson.annotations.SerializedName

class DrinkResponse(
    val drinks: List<Drink>
)

class DrinkDetailResponse(
    val drinks: List<DrinkDetail>
)

class CategoryResponse(
    @SerializedName("drinks")
    val categories: List<Category>
)

class IngredientResponse(
    @SerializedName("drinks")
    val ingredients: List<Ingredient>
)
