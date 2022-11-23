package com.sildev.thecocktail.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sildev.thecocktail.base.BaseViewModel
import com.sildev.thecocktail.data.model.Drink
import com.sildev.thecocktail.data.model.Search
import com.sildev.thecocktail.data.repository.SearchRepository

class SearchViewModel(private val repository: SearchRepository) : BaseViewModel() {
    private val _suggestList = MutableLiveData<List<Search>>()
    val suggestList: LiveData<List<Search>> get() = _suggestList
    private val _drinkList = MutableLiveData<List<Drink>>()
    val drinkList: LiveData<List<Drink>> get() = _drinkList

    fun suggestDrinkName(key: String) {
        launchAsync(request = { repository.suggestDrinkName(key) }, onSuccess = {
            _suggestList.value = it
        }, onError = {
            it.message.toString()
        })
    }

    fun searchDrinkByName(key: String) {
        launchAsync(request = { repository.searchByName(key) }, onSuccess = {
            _drinkList.value = it
        }, onError = {
            it.message.toString()
        })
    }

    fun addSearchHistory(search: Search) {
        launchAsync(request = { repository.addSearchHistory(search) },
            onSuccess = {},
            onError = { it.message.toString() })
    }

    fun deleteSearchHistory() {
        launchAsync(request = { repository.deleteSearchHistory() },
            onSuccess = {},
            onError = { it.message.toString() })
    }

}
