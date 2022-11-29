package com.sildev.thecocktail.ui.detail

import android.os.Bundle
import android.os.Parcelable
import com.sildev.thecocktail.R
import com.sildev.thecocktail.base.BaseActivity
import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.data.model.DrinkDetail
import com.sildev.thecocktail.data.model.IngredientDetail
import com.sildev.thecocktail.databinding.ActivityDetailBinding
import com.sildev.thecocktail.ui.adapter.IngredientDetailAdapter
import com.sildev.thecocktail.utils.Constant
import com.sildev.thecocktail.utils.extension.loadImage
import com.sildev.thecocktail.utils.extension.setVisible
import com.sildev.thecocktail.utils.extension.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : BaseActivity<ActivityDetailBinding>(ActivityDetailBinding::inflate) {

    override val viewModel: DetailViewModel by viewModel()
    private val drink: Drink by lazy {
        intent.getParcelableExtra<Parcelable>(Constant.EXTRA_CATEGORY_DATA_KEY) as Drink
    }

    private val ingredientAdapter = IngredientDetailAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        binding.btnFavourite.setOnClickListener {
            if (viewModel.isFavourite.value == true) {
                viewModel.deleteFromFavourite(drink)
            } else {
                viewModel.addToFavourite(drink)
            }
        }
        binding.recyclerviewIngredients.adapter = ingredientAdapter

        viewModel.requestDetailDrink(drink.idDrink)
        viewModel.checkIsFavourite(drink.idDrink)
        viewModel.detailDrink.observe(this) {
            binding.apply {
                imageDetail.loadImage(it.strDrinkThumb)
                textCategory.text = it.strCategory
                collapsingDetail.title = it.strDrink
                textInstruction.text = it.strInstructions
                btnFavourite.setVisible()
                shimmerImageDetail.hideShimmer()
                ingredientAdapter.submitList(it.getIngredientDetails())
            }
        }
        viewModel.isFavourite.observe(this) {
            if (it) {
                binding.btnFavourite.setImageResource(R.drawable.ic_heart)
            } else {
                binding.btnFavourite.setImageResource(R.drawable.ic_heart_line)
            }
        }

    }
}
