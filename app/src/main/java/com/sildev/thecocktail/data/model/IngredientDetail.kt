package com.sildev.thecocktail.data.model

import androidx.recyclerview.widget.DiffUtil

data class IngredientDetail(
    val name: String, val measure: String
) {

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<IngredientDetail>() {
            override fun areItemsTheSame(
                oldItem: IngredientDetail, newItem: IngredientDetail
            ): Boolean = false

            override fun areContentsTheSame(
                oldItem: IngredientDetail, newItem: IngredientDetail
            ): Boolean = oldItem == newItem

        }
    }
}
