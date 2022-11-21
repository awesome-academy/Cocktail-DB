package com.sildev.thecocktail.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sildev.thecocktail.base.BaseAdapter
import com.sildev.thecocktail.base.BaseViewHolder
import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.databinding.ItemDrinkBinding
import com.sildev.thecocktail.utils.extension.loadImage

class DrinkAdapter(private val onclickItem: (Drink) -> Unit) :
    BaseAdapter<Drink, ItemDrinkBinding, DrinkAdapter.DrinkViewHolder>(
        Drink.diffUtil
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val binding = ItemDrinkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DrinkViewHolder(binding, onclickItem)
    }

    class DrinkViewHolder(
        private val itemBinding: ItemDrinkBinding, onclickItem: (Drink) -> Unit
    ) : BaseViewHolder<Drink, ItemDrinkBinding>(itemBinding, onclickItem) {
        override fun onBindData(data: Drink) {
            itemBinding.textNameDrink.text = data.strDrink
            itemBinding.imageDrink.loadImage(
                data.strDrinkThumb
            )
        }
    }
}
