package com.sildev.thecocktail.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sildev.thecocktail.base.BaseViewModel
import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.data.model.DrinkDetailCollapse
import com.sildev.thecocktail.data.repository.DetailRepository

class DetailViewModel(private val detailRepository: DetailRepository) : BaseViewModel() {

    private val _detailDrink = MutableLiveData<DrinkDetailCollapse>()
    val detailDrink: LiveData<DrinkDetailCollapse>
        get() = _detailDrink
    private val _isFavourite = MutableLiveData<Boolean>()
    val isFavourite: LiveData<Boolean>
        get() = _isFavourite


    fun requestDetailDrink(id: String) {
        launchAsync(request = { detailRepository.getDetailDrink(id) },
            onSuccess = { _detailDrink.value = it },
            onError = { it.message.toString() })
    }

    fun addToFavourite(drink: Drink) {
        launchAsync(request = { detailRepository.addToFavourite(drink) },
            onSuccess = { _isFavourite.value = true },
            onError = { it.message.toString() })
    }

    fun deleteFromFavourite(drink: Drink) {
        launchAsync(request = { detailRepository.deleteFromFavourite(drink) },
            onSuccess = { _isFavourite.value = false },
            onError = { it.message.toString() })
    }

    fun checkIsFavourite(id: String) {
        launchAsync(request = { detailRepository.drinkIsFavourite(id) },
            onSuccess = { _isFavourite.value = it },
            onError = { it.message.toString() })
    }
}
