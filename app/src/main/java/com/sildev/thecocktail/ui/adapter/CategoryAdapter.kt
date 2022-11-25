package com.sildev.thecocktail.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sildev.thecocktail.base.BaseAdapter
import com.sildev.thecocktail.base.BaseViewHolder
import com.sildev.thecocktail.data.model.Category
import com.sildev.thecocktail.databinding.ItemCategoryBinding

class CategoryAdapter(private val onclickItem: (Category) -> Unit) :
    BaseAdapter<Category, ItemCategoryBinding, CategoryAdapter.CategoryViewHolder>(Category.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding =
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding, onclickItem)
    }

    class CategoryViewHolder(
        private val binding: ItemCategoryBinding, private val onclickItem: (Category) -> Unit
    ) : BaseViewHolder<Category, ItemCategoryBinding>(binding, onclickItem) {
        override fun onBindData(data: Category) {
            super.onBindData(data)
            binding.textNameCategory.text = data.name
            binding.imageCategory.setImageResource(data.getCategoryMap())
        }
    }
}
