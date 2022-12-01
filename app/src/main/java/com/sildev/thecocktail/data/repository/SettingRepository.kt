package com.sildev.thecocktail.data.repository

interface SettingRepository {
    fun getNightMode(): Boolean
    fun setNightMode(value: Boolean)
    fun getLanguage(): Boolean
    fun setLanguage(value: Boolean)
}
