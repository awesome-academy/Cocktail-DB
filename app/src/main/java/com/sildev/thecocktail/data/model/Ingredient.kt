package com.sildev.thecocktail.data.model

import com.google.gson.annotations.SerializedName

data class Ingredient(
    @SerializedName("strIngredient1")
    val name: String
)
