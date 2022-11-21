package com.sildev.thecocktail.data.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ingredient(
    @SerializedName("strIngredient1") val name: String
): Parcelable {

    companion object {

        val diffUtil = object : DiffUtil.ItemCallback<Ingredient>() {
            override fun areItemsTheSame(oldItem: Ingredient, newItem: Ingredient) =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: Ingredient, newItem: Ingredient) =
                oldItem == newItem
        }
    }
}
