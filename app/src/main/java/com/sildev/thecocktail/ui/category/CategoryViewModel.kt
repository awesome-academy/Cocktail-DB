package com.sildev.thecocktail.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sildev.thecocktail.base.BaseViewModel
import com.sildev.thecocktail.data.model.Category
import com.sildev.thecocktail.data.repository.CategoryRepository

class CategoryViewModel(private val categoryRepository: CategoryRepository) : BaseViewModel() {
    private val _categoryList = MutableLiveData<List<Category>>()
    val categoryList: LiveData<List<Category>> get() = _categoryList

    init {
        requestCategoryList()
    }

    private fun requestCategoryList() {
        launchAsync(request = { categoryRepository.getCategory() },
            onSuccess = {_categoryList.value = it },
            onError = { it.message.toString() })
    }
}
