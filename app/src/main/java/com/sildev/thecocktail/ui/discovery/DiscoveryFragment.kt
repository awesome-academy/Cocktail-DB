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
import com.sildev.thecocktail.ui.adapter.DrinkAdapter
import com.sildev.thecocktail.ui.adapter.IngredientAdapter
import com.sildev.thecocktail.ui.detail.DetailActivity
import com.sildev.thecocktail.ui.drinks.DrinksActivity
import com.sildev.thecocktail.ui.search.SearchActivity
import com.sildev.thecocktail.ui.seeall.SeeAllActivity
import com.sildev.thecocktail.utils.Constant
import com.sildev.thecocktail.utils.Constant.EXTRA_INGREDIENT_LIST_DATA_KEY
import com.sildev.thecocktail.utils.extension.loadImage
import com.sildev.thecocktail.utils.extension.setVisible
import org.koin.androidx.viewmodel.ext.android.viewModel

class DiscoveryFragment :
    BaseFragment<FragmentDiscoveryBinding>(FragmentDiscoveryBinding::inflate) {

    override val viewModel: DiscoveryViewModel by viewModel()
    private val ingredientAdapter = IngredientAdapter(::onClickIngredientItem)
    private val drinkAdapter = DrinkAdapter(::onClickDrinkItem)
    private val listIngredient = mutableListOf<Ingredient>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            recyclerviewIngredients.adapter = ingredientAdapter
            recyclerviewCocktail.adapter = drinkAdapter
            textSeeMore.setOnClickListener {
                val intent = Intent(context, SeeAllActivity::class.java)
                val ingredientData = Ingredient.fromListIngredient(listIngredient)
                intent.putExtra(EXTRA_INGREDIENT_LIST_DATA_KEY, ingredientData)
                startActivity(intent)
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
            listIngredient.addAll(it)
            ingredientAdapter.submitList(it.subList(Constant.FIRST_INDEX, Constant.INGREDIENT_SIZE))
            binding.shimmerIngredients.isVisible = false
            binding.textSeeMore.setVisible()
        })
        viewModel.cocktails.observe(viewLifecycleOwner, Observer {
            drinkAdapter.submitList(it)
            binding.shimmerCocktails.isVisible = false
        })

    }

    private fun onClickIngredientItem(ingredient: Ingredient) {
        val intent = Intent(context, DrinksActivity::class.java)
        intent.putExtra(Constant.EXTRA_INGREDIENT_DATA_KEY, ingredient)
        intent.putExtra(Constant.EXTRA_TYPE_KEY, Constant.TYPE_INGREDIENT)
        startActivity(intent)
    }

    private fun onClickDrinkItem(drink: Drink) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(Constant.EXTRA_DRINK_DATA_KEY, drink)
        startActivity(intent)
    }
}
