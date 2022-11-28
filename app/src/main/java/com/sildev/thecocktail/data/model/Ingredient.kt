package com.sildev.thecocktail.data.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import org.json.JSONArray

@Parcelize
data class Ingredient(
    @SerializedName("strIngredient1") val name: String
) : Parcelable {

    companion object {

        val diffUtil = object : DiffUtil.ItemCallback<Ingredient>() {
            override fun areItemsTheSame(oldItem: Ingredient, newItem: Ingredient) =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: Ingredient, newItem: Ingredient) =
                oldItem == newItem
        }

        fun fromString(data: String?): List<Ingredient> {
            val list = Gson().fromJson(data, Array<Ingredient>::class.java)
            return list.toList()
        }

        fun fromListIngredient(ingredients: List<Ingredient>): String {
            val jsonArray = Gson().toJsonTree(ingredients).asJsonArray
            return jsonArray.toString()
        }
    }
}
