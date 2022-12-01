package com.sildev.thecocktail.ui.setting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sildev.thecocktail.base.BaseViewModel
import com.sildev.thecocktail.data.repository.SettingRepository

class SettingViewModel(private val settingRepository: SettingRepository) : BaseViewModel() {

    private val _isNightMode = MutableLiveData<Boolean>()
    val isNightMode: LiveData<Boolean> get() = _isNightMode
    private val _isEnglish = MutableLiveData<Boolean>()
    val isEnglish: LiveData<Boolean> get() = _isEnglish

    init {
        getNightMode()
        getLanguage()
    }

    private fun getNightMode() {
        _isNightMode.value = settingRepository.getNightMode()
    }

    fun setNightMode(value: Boolean) {
        settingRepository.setNightMode(value)
        _isNightMode.value = value
    }

    private fun getLanguage() {
        _isEnglish.value = settingRepository.getLanguage()
    }

    fun setLanguage(value: Boolean) {
        settingRepository.setLanguage(value)
        _isEnglish.value = value
    }
}
