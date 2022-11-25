package com.sildev.thecocktail.data.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import com.sildev.thecocktail.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    @SerializedName("strCategory") val name: String
) : Parcelable {

    fun getCategoryMap() = when (name) {
        CategoryThumb.CATEGORY_COCKTAIL -> R.drawable.img_cocktail
        CategoryThumb.CATEGORY_ORDINARY -> R.drawable.img_original_drink
        CategoryThumb.CATEGORY_COCOA -> R.drawable.img_cocoa
        CategoryThumb.CATEGORY_COFFEE_TEA -> R.drawable.img_coffee_tea
        CategoryThumb.CATEGORY_SOFT_DRINK -> R.drawable.img_soda
        CategoryThumb.CATEGORY_PARTY_DRINK -> R.drawable.img_party_drink
        CategoryThumb.CATEGORY_MILK_SHAKE -> R.drawable.img_milk_shake
        CategoryThumb.CATEGORY_HOMEMADE -> R.drawable.img_home_made
        CategoryThumb.CATEGORY_BEER -> R.drawable.img_beer
        CategoryThumb.CATEGORY_OTHER -> R.drawable.img_other_drink
        CategoryThumb.CATEGORY_SHOT -> R.drawable.img_shot
        else -> R.drawable.cocktail
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Category>() {
            override fun areItemsTheSame(oldItem: Category, newItem: Category) =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: Category, newItem: Category) =
                oldItem == newItem
        }
    }
}

object CategoryThumb {
    const val CATEGORY_MILK_SHAKE = "Milk / Float / Shake"
    const val CATEGORY_OTHER = "Other/Unknown"
    const val CATEGORY_COFFEE_TEA = "Coffee / Tea"
    const val CATEGORY_HOMEMADE = "Homemade Liqueur"
    const val CATEGORY_PARTY_DRINK = "Punch / Party Drink"
    const val CATEGORY_BEER = "Beer"
    const val CATEGORY_SOFT_DRINK = "Soft Drink / Soda"
    const val CATEGORY_ORDINARY = "Ordinary Drink"
    const val CATEGORY_COCOA = "Cocoa"
    const val CATEGORY_COCKTAIL = "Cocktail"
    const val CATEGORY_SHOT = "Shot"
}
