package com.sildev.thecocktail.ui.discovery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sildev.thecocktail.base.BaseViewModel
import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.data.model.Ingredient
import com.sildev.thecocktail.data.repository.DiscoveryRepository

class DiscoveryViewModel(private val repository: DiscoveryRepository) : BaseViewModel() {
    private val _drinkRandoms = MutableLiveData<List<Drink>>()
    val drinkRandoms: LiveData<List<Drink>> get() = _drinkRandoms
    private val _ingredients = MutableLiveData<List<Ingredient>>()
    val ingredient: LiveData<List<Ingredient>> get() = _ingredients
    private val _cocktails = MutableLiveData<List<Drink>>()
    val cocktails: LiveData<List<Drink>> get() = _cocktails

    init {
        requestDrinkRandom()
        requestIngredients()
        requestCocktails()
    }

    private fun requestDrinkRandom() {
        launchAsync(request = { repository.getRandomDrink() }, onSuccess = {
            _drinkRandoms.value = it
        }, onError = {
            it.message.toString()
        })
    }

    private fun requestIngredients() {
        launchAsync(request = { repository.getIngredients() }, onSuccess = {
            _ingredients.value = it
        }, onError = {
            it.message.toString()
        })
    }

    private fun requestCocktails() {
        launchAsync(request = { repository.getCocktails() }, onSuccess = {
            _cocktails.value = it
        }, onError = {
            it.message.toString()
        })
    }
}
