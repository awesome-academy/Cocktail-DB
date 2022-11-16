package com.sildev.thecocktail.data.model

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("strCategory")
    val name: String?
)
