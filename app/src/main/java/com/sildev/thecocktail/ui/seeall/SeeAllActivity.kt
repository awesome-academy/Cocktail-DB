package com.sildev.thecocktail.ui.seeall

import android.content.Intent
import android.os.Bundle
import com.sildev.thecocktail.base.BaseActivity
import com.sildev.thecocktail.data.model.Ingredient
import com.sildev.thecocktail.databinding.ActivitySeeAllBinding
import com.sildev.thecocktail.ui.adapter.IngredientAdapter
import com.sildev.thecocktail.ui.drinks.DrinksActivity
import com.sildev.thecocktail.utils.Constant
import org.koin.androidx.viewmodel.ext.android.viewModel

class SeeAllActivity : BaseActivity<ActivitySeeAllBinding>(ActivitySeeAllBinding::inflate) {
    override val viewModel: SeeAllViewModel by viewModel()
    private val ingredientAdapter = IngredientAdapter(::onIngredientItemClick)
    private val listIngredient: List<Ingredient> by lazy {
        Ingredient.fromString(intent.getStringExtra(Constant.EXTRA_INGREDIENT_LIST_DATA_KEY))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.recyclerviewIngredients.adapter = ingredientAdapter
        binding.toolbarIngredient.setNavigationOnClickListener {
            finish()
        }
        ingredientAdapter.submitList(listIngredient)
    }

    private fun onIngredientItemClick(ingredient: Ingredient) {
        val intent = Intent(this, DrinksActivity::class.java)
        intent.putExtra(Constant.EXTRA_INGREDIENT_DATA_KEY, ingredient)
        intent.putExtra(Constant.EXTRA_TYPE_KEY, Constant.TYPE_INGREDIENT)
        startActivity(intent)
    }
}
