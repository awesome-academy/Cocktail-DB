package com.sildev.thecocktail.data.model

import androidx.recyclerview.widget.DiffUtil

data class DrinkDetailCollapse(
    val idDrink: String,
    val strDrink: String,
    val strDrinkAlternate: String,
    val strCategory: String,
    val strAlcoholic: String,
    val strInstructions: String,
    val strDrinkThumb: String,
    val ingredients: List<String?>?,
    val measures: List<String?>?,
    val dateModified: String
) {

    fun getIngredientDetails(): List<IngredientDetail> {
        val list = mutableListOf<IngredientDetail>()
        val length = ingredients?.size ?: 0
        for (i in 0 until length) {
            ingredients?.get(i)?.let {
                if (it.isNotBlank()) {
                    list.add(IngredientDetail(it, (measures?.get(i) ?: "")))
                }
            }
        }
        return list
    }

    companion object {

        val diffUtil = object : DiffUtil.ItemCallback<DrinkDetailCollapse>() {
            override fun areItemsTheSame(
                oldItem: DrinkDetailCollapse, newItem: DrinkDetailCollapse
            ) = oldItem.idDrink == newItem.idDrink

            override fun areContentsTheSame(
                oldItem: DrinkDetailCollapse, newItem: DrinkDetailCollapse
            ) = oldItem == newItem
        }
    }
}
