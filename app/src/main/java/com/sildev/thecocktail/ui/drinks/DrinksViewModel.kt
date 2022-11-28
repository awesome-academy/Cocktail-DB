package com.sildev.thecocktail.ui.drinks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sildev.thecocktail.base.BaseViewModel
import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.data.repository.DrinksRepository

class DrinksViewModel(private val drinksRepository: DrinksRepository) : BaseViewModel() {
    private val _drinkList = MutableLiveData<List<Drink>>()
    val drinkList: LiveData<List<Drink>> get() = _drinkList


    fun requestDrinkListByCategory(category: String) {
        launchAsync(request = { drinksRepository.getDrinksByCategory(category) },
            onSuccess = { _drinkList.value = it },
            onError = { it.message.toString() })
    }

    fun requestDrinkListByIngredient(ingredient: String) {
        launchAsync(request = { drinksRepository.getDrinksByIngredient(ingredient) },
            onSuccess = { _drinkList.value = it },
            onError = { it.message.toString() })
    }
}
