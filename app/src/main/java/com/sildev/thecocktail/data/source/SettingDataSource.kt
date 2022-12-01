package com.sildev.thecocktail.data.source

interface SettingDataSource {

    interface Local {
        fun getNightMode(): Boolean
        fun setNightMode(value: Boolean)
        fun getLanguage(): Boolean
        fun setLanguage(value: Boolean)
    }
}
