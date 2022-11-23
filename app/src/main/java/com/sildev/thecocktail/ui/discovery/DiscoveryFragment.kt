package com.sildev.thecocktail.ui.discovery

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.sildev.thecocktail.base.BaseFragment
import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.data.model.Ingredient
import com.sildev.thecocktail.databinding.FragmentDiscoveryBinding
import com.sildev.thecocktail.ui.SeeAllActivity
import com.sildev.thecocktail.ui.adapter.DrinkAdapter
import com.sildev.thecocktail.ui.adapter.IngredientAdapter
import com.sildev.thecocktail.ui.detail.DetailActivity
import com.sildev.thecocktail.ui.search.SearchActivity
import com.sildev.thecocktail.utils.Constant
import com.sildev.thecocktail.utils.extension.loadImage
import org.koin.androidx.viewmodel.ext.android.viewModel

class DiscoveryFragment :
    BaseFragment<FragmentDiscoveryBinding>(FragmentDiscoveryBinding::inflate) {

    override val viewModel: DiscoveryViewModel by viewModel()
    private val ingredientAdapter = IngredientAdapter(::onClickIngredientItem)
    private val drinkAdapter = DrinkAdapter(::onClickDrinkItem)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            recyclerviewIngredients.adapter = ingredientAdapter
            recyclerviewCocktail.adapter = drinkAdapter
            textSeeMore.setOnClickListener {
                startActivity(Intent(context, SeeAllActivity::class.java))
            }
            layoutSearch.setOnClickListener {
                startActivity(Intent(context, SearchActivity::class.java))
            }
        }

        viewModel.drinkRandoms.observe(viewLifecycleOwner, Observer {
            val drink = it[0]
            binding.apply {
                imageSuggest.loadImage(drink.strDrinkThumb)
                textNameSuggest.text = drink.strDrink
                shimmerSuggest.hideShimmer()
                shimmerSuggest.setOnClickListener {
                    onClickDrinkItem(drink)
                }
            }

        })
        viewModel.ingredient.observe(viewLifecycleOwner, Observer {
            ingredientAdapter.submitList(it.subList(Constant.FIRST_INDEX, Constant.INGREDIENT_SIZE))
            binding.shimmerIngredients.isVisible = false
        })
        viewModel.cocktails.observe(viewLifecycleOwner, Observer {
            drinkAdapter.submitList(it)
            binding.shimmerCocktails.isVisible = false
        })

    }

    private fun onClickIngredientItem(ingredient: Ingredient) {
        val intent = Intent(context, SeeAllActivity::class.java)
        intent.putExtra(Constant.EXTRA_INGREDIENT_DATA_KEY, ingredient)
        startActivity(intent)
    }

    private fun onClickDrinkItem(drink: Drink) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(Constant.EXTRA_DRINK_DATA_KEY, drink)
        startActivity(intent)
    }
}
