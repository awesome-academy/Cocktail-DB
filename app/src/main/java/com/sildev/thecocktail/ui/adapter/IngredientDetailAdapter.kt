package com.sildev.thecocktail.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sildev.thecocktail.base.BaseAdapter
import com.sildev.thecocktail.base.BaseViewHolder
import com.sildev.thecocktail.data.model.IngredientDetail
import com.sildev.thecocktail.databinding.ItemIngredientDetailBinding
import com.sildev.thecocktail.utils.Constant
import com.sildev.thecocktail.utils.extension.loadImage

class IngredientDetailAdapter :
    BaseAdapter<IngredientDetail, ItemIngredientDetailBinding, IngredientDetailAdapter.IngredientDetailViewHolder>(
        IngredientDetail.diffUtil
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientDetailViewHolder {
        val binding =
            ItemIngredientDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return IngredientDetailViewHolder(binding)
    }

    class IngredientDetailViewHolder(
        private val itemBinding: ItemIngredientDetailBinding
    ) : BaseViewHolder<IngredientDetail, ItemIngredientDetailBinding>(itemBinding) {
        override fun onBindData(data: IngredientDetail) {
            super.onBindData(data)
            itemBinding.textIngredient.text = data.name
            itemBinding.textMeasure.text = data.measure
            itemBinding.imageIngredient.loadImage(
                Constant.BASE_INGREDIENT_IMAGE + data.name + Constant.MEDIUM_PNG_EXTENSION
            )
        }
    }
}
