package com.sildev.thecocktail.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sildev.thecocktail.base.BaseAdapter
import com.sildev.thecocktail.base.BaseViewHolder
import com.sildev.thecocktail.data.model.Search
import com.sildev.thecocktail.databinding.ItemSearchBinding

class SuggestAdapter(private val onItemClick: (Search) -> Unit) :
    BaseAdapter<Search, ItemSearchBinding, SuggestAdapter.SuggestViewHolder>(Search.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestViewHolder {
        val binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SuggestViewHolder(binding, onItemClick)

    }

    class SuggestViewHolder(
        private val itemBinding: ItemSearchBinding, private val onItemClick: (Search) -> Unit
    ) : BaseViewHolder<Search, ItemSearchBinding>(itemBinding, onItemClick) {
        override fun onBindData(data: Search) {
            super.onBindData(data)
            itemBinding.textSuggest.text = data.name
        }
    }
}
