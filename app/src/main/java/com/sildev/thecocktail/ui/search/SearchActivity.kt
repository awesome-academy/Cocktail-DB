package com.sildev.thecocktail.ui.search

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import com.sildev.thecocktail.R
import com.sildev.thecocktail.base.BaseActivity
import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.data.model.Search
import com.sildev.thecocktail.databinding.ActivitySearchBinding
import com.sildev.thecocktail.ui.adapter.DrinkAdapter
import com.sildev.thecocktail.ui.adapter.SuggestAdapter
import com.sildev.thecocktail.ui.detail.DetailActivity
import com.sildev.thecocktail.utils.Constant
import com.sildev.thecocktail.utils.Constant.EMPTY_STRING
import com.sildev.thecocktail.utils.Constant.EXTRA_DRINK_DATA_KEY
import com.sildev.thecocktail.utils.extension.setInvisible
import com.sildev.thecocktail.utils.extension.setVisible
import kotlinx.coroutines.Job
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class SearchActivity : BaseActivity<ActivitySearchBinding>(ActivitySearchBinding::inflate) {

    override val viewModel: SearchViewModel by viewModel()
    private val suggestAdapter = SuggestAdapter(::onSuggestItemClick)
    private val drinkAdapter = DrinkAdapter(::onDrinkItemClick)
    private var job = Job()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.recyclerviewSuggest.adapter = suggestAdapter
        binding.recyclerviewResult.adapter = drinkAdapter
        binding.searchViewDrink.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                val key = query.toString().trim()
                viewModel.searchDrinkByName(key)
                binding.recyclerviewSuggest.setInvisible()
                binding.recyclerviewResult.setVisible()
                viewModel.addSearchHistory(Search(key))
                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {
                job.cancel()
                job = Job()
                CoroutineScope(job).launch {
                    delay(Constant.TIME_DELAY_SEARCH)
                    val key = query.toString().trim()
                    viewModel.suggestDrinkName(key)
                }
                binding.apply {
                    recyclerviewSuggest.setVisible()
                    recyclerviewResult.setInvisible()
                }
                return true
            }
        })
        binding.searchViewDrink.onActionViewExpanded()
        viewModel.suggestList.observe(this) {
            suggestAdapter.submitList(it)
        }
        viewModel.drinkList.observe(this) {
            drinkAdapter.submitList(it)
        }

        binding.textDeleteSearchHistory.setOnClickListener {
            val alertDeleteDialog = AlertDialog.Builder(this@SearchActivity)
                .setMessage(getString(R.string.question_delete))
                .setNegativeButton(getString(R.string.cancel)) { dialog, _ ->
                    dialog.dismiss()
                }.setPositiveButton(getString(R.string.yes)) { _, _ ->
                    viewModel.deleteSearchHistory()
                    binding.searchViewDrink.setQuery(EMPTY_STRING, true)
                }.setCancelable(false).create()
            alertDeleteDialog.show()
        }
    }

    private fun onSuggestItemClick(search: Search) {
        binding.searchViewDrink.setQuery(search.name, true)
        viewModel.addSearchHistory(search)
    }

    private fun onDrinkItemClick(drink: Drink) {
        val intent = Intent(this@SearchActivity, DetailActivity::class.java)
        intent.putExtra(EXTRA_DRINK_DATA_KEY, drink)
        startActivity(intent)
    }
}
