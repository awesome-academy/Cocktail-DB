package com.sildev.thecocktail.ui.favourite

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.sildev.thecocktail.base.BaseFragment
import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.databinding.FragmentFavouriteBinding
import com.sildev.thecocktail.ui.adapter.DrinkAdapter
import com.sildev.thecocktail.ui.detail.DetailActivity
import com.sildev.thecocktail.utils.Constant
import com.sildev.thecocktail.utils.extension.setInvisible
import com.sildev.thecocktail.utils.extension.setVisible
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavouriteFragment :
    BaseFragment<FragmentFavouriteBinding>(FragmentFavouriteBinding::inflate) {

    override val viewModel: FavouriteViewModel by viewModel()
    private val drinkAdapter = DrinkAdapter(::onItemDrinkClick)

    override fun onResume() {
        viewModel.requestFavourite()
        super.onResume()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerviewFavourite.adapter = drinkAdapter

        viewModel.favouriteList.observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                binding.layoutEmpty.setVisible()
                binding.recyclerviewFavourite.setInvisible()
            } else {
                binding.layoutEmpty.setInvisible()
                binding.recyclerviewFavourite.setVisible()
                drinkAdapter.submitList(it)
            }
        }
    }

    private fun onItemDrinkClick(drink: Drink) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(Constant.EXTRA_DRINK_DATA_KEY, drink)
        startActivity(intent)
    }
}
