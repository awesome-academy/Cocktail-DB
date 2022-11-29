package com.sildev.thecocktail.ui.favourite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sildev.thecocktail.base.BaseViewModel
import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.data.repository.FavouriteRepository

class FavouriteViewModel(private val favouriteRepository: FavouriteRepository) : BaseViewModel() {
    private val _favouriteList = MutableLiveData<List<Drink>>()
    val favouriteList: LiveData<List<Drink>> get() = _favouriteList

    fun requestFavourite() {
        launchAsync(request = { favouriteRepository.getFavourites() },
            onSuccess = { _favouriteList.value = it },
            onError = { it.message.toString() })
    }
}
