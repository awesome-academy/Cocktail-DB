package com.sildev.thecocktail.ui.category

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sildev.thecocktail.R
import com.sildev.thecocktail.base.BaseFragment
import com.sildev.thecocktail.data.model.Category
import com.sildev.thecocktail.databinding.FragmentCategoryBinding
import com.sildev.thecocktail.ui.adapter.CategoryAdapter
import com.sildev.thecocktail.ui.drinks.DrinksActivity
import com.sildev.thecocktail.utils.Constant
import com.sildev.thecocktail.utils.extension.setInvisible
import com.sildev.thecocktail.utils.extension.setVisible
import org.koin.androidx.viewmodel.ext.android.viewModel

class CategoryFragment : BaseFragment<FragmentCategoryBinding>(FragmentCategoryBinding::inflate) {

    private val categoryAdapter = CategoryAdapter(::onClickCategoryItem)
    private val layoutLinear = LinearLayoutManager(context)
    private val layoutGrid = GridLayoutManager(context, Constant.SPAN_COUNT_CATEGORY)
    private var gridDisplay = false
    override val viewModel: CategoryViewModel by viewModel()
    private val listCategory = mutableListOf<Category>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerviewCategory.adapter = categoryAdapter

        binding.imageTypeView.setOnClickListener {
            if (gridDisplay) {
                binding.recyclerviewCategory.layoutManager = layoutLinear
                binding.imageTypeView.setImageResource(R.drawable.ic_grid)
            } else {
                binding.recyclerviewCategory.layoutManager = layoutGrid
                binding.imageTypeView.setImageResource(R.drawable.ic_list)
            }
            gridDisplay = gridDisplay.not()

        }
        viewModel.categoryList.observe(viewLifecycleOwner) {
            categoryAdapter.submitList(it)
            listCategory.apply {
                clear()
                addAll(it)
            }
            binding.shimmerCategory.hideShimmer()
            binding.shimmerCategory.setInvisible()
            if (it.isEmpty()) {
                binding.textEmpty.setVisible()
            } else {
                binding.textEmpty.setInvisible()
            }
        }
        binding.editSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // do late
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // do late
            }

            override fun afterTextChanged(query: Editable?) {
                val key = query.toString().trim()
                val listResult = listCategory.filter { it.name.contains(key) }
                categoryAdapter.submitList(listResult)
                if (listResult.isEmpty()) {
                    binding.textEmpty.setVisible()
                } else {
                    binding.textEmpty.setInvisible()
                }
            }
        })
    }

    private fun onClickCategoryItem(category: Category) {
        val intent = Intent(context, DrinksActivity::class.java)
        intent.putExtra(Constant.EXTRA_TYPE_KEY, Constant.TYPE_CATEGORY)
        intent.putExtra(Constant.EXTRA_CATEGORY_DATA_KEY, category)
        startActivity(intent)
    }
}
