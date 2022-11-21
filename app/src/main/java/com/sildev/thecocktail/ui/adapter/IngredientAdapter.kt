package com.sildev.thecocktail.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sildev.thecocktail.base.BaseAdapter
import com.sildev.thecocktail.base.BaseViewHolder
import com.sildev.thecocktail.data.model.Ingredient
import com.sildev.thecocktail.databinding.ItemIngredientBinding
import com.sildev.thecocktail.utils.Constant
import com.sildev.thecocktail.utils.extension.loadImage

class IngredientAdapter(private val onclickItem: (Ingredient) -> Unit) :
    BaseAdapter<Ingredient, ItemIngredientBinding, IngredientAdapter.IngredientViewHolder>(
        Ingredient.diffUtil
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        val binding =
            ItemIngredientBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return IngredientViewHolder(binding, onclickItem)
    }

    class IngredientViewHolder(
        private val itemBinding: ItemIngredientBinding, onclickItem: (Ingredient) -> Unit
    ) : BaseViewHolder<Ingredient, ItemIngredientBinding>(itemBinding, onclickItem) {
        override fun onBindData(data: Ingredient) {
            itemBinding.textCategory.text = data.name
            itemBinding.imageCategory.loadImage(
                Constant.BASE_INGREDIENT_IMAGE + data.name + Constant.MEDIUM_PNG_EXTENSION
            )
        }
    }
}
