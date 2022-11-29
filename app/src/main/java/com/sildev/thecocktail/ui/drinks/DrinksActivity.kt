package com.sildev.thecocktail.ui.drinks

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sildev.thecocktail.R
import com.sildev.thecocktail.base.BaseActivity
import com.sildev.thecocktail.data.model.Category
import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.data.model.Ingredient
import com.sildev.thecocktail.databinding.ActivityDrinksBinding
import com.sildev.thecocktail.ui.adapter.DrinkAdapter
import com.sildev.thecocktail.ui.detail.DetailActivity
import com.sildev.thecocktail.utils.Constant
import com.sildev.thecocktail.utils.Constant.EXTRA_CATEGORY_DATA_KEY
import com.sildev.thecocktail.utils.Constant.EXTRA_INGREDIENT_DATA_KEY
import com.sildev.thecocktail.utils.Constant.TYPE_CATEGORY
import com.sildev.thecocktail.utils.extension.setInvisible
import org.koin.androidx.viewmodel.ext.android.viewModel

class DrinksActivity : BaseActivity<ActivityDrinksBinding>(ActivityDrinksBinding::inflate) {

    override val viewModel: DrinksViewModel by viewModel()
    private val typeData: String by lazy {
        intent.getStringExtra(Constant.EXTRA_TYPE_KEY).toString()
    }
    private val drinkAdapter = DrinkAdapter(::onClickDrinkItem)
    private val layoutLinear = LinearLayoutManager(this)
    private val layoutGrid = GridLayoutManager(this, Constant.SPAN_COUNT_CATEGORY)
    private var gridDisplay = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.recyclerviewDrink.adapter = drinkAdapter
        if (typeData == TYPE_CATEGORY) {
            val category =
                intent.getParcelableExtra<Parcelable>(EXTRA_CATEGORY_DATA_KEY) as Category
            viewModel.requestDrinkListByCategory(category.name)
            binding.toolbarDrink.title = category.name
        } else {
            val ingredient =
                intent.getParcelableExtra<Parcelable>(EXTRA_INGREDIENT_DATA_KEY) as Ingredient
            viewModel.requestDrinkListByIngredient(ingredient.name)
            binding.toolbarDrink.title = ingredient.name
        }
        binding.toolbarDrink.setOnMenuItemClickListener {
            if (it.itemId == R.id.item_type_view) {
                val currentPosition: Int
                if (gridDisplay) {
                    currentPosition =
                        (binding.recyclerviewDrink.layoutManager as GridLayoutManager).findFirstVisibleItemPosition()
                    binding.recyclerviewDrink.layoutManager = layoutLinear
                    it.setIcon(R.drawable.ic_grid)
                } else {
                    currentPosition =
                        (binding.recyclerviewDrink.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                    binding.recyclerviewDrink.layoutManager = layoutGrid
                    it.setIcon(R.drawable.ic_list)
                }
                gridDisplay = gridDisplay.not()
                binding.recyclerviewDrink.scrollToPosition(currentPosition)
            }
            true
        }
        binding.toolbarDrink.setNavigationOnClickListener {
            finish()
        }

        viewModel.drinkList.observe(this) {
            binding.shimmerDrinks.setInvisible()
            drinkAdapter.submitList(it)
        }
    }

    private fun onClickDrinkItem(drink: Drink) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(Constant.EXTRA_DRINK_DATA_KEY, drink)
        startActivity(intent)
    }
}
