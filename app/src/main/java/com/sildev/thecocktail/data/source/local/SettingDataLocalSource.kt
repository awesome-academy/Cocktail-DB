package com.sildev.thecocktail.data.source.local

import com.sildev.thecocktail.data.source.SettingDataSource
import com.sildev.thecocktail.data.source.local.sharedpref.SharedPrefApi
import com.sildev.thecocktail.data.source.local.sharedpref.SharedPrefKey.KEY_LANGUAGE
import com.sildev.thecocktail.data.source.local.sharedpref.SharedPrefKey.KEY_NIGHT_MODE

class SettingDataLocalSource(private val sharedPrefApi: SharedPrefApi) : SettingDataSource.Local {

    override fun getNightMode(): Boolean = sharedPrefApi.getBoolean(KEY_NIGHT_MODE)

    override fun setNightMode(value: Boolean) = sharedPrefApi.setBoolean(KEY_NIGHT_MODE, value)

    override fun getLanguage(): Boolean = sharedPrefApi.getBoolean(KEY_LANGUAGE)

    override fun setLanguage(value: Boolean) = sharedPrefApi.setBoolean(KEY_LANGUAGE, value)
}
