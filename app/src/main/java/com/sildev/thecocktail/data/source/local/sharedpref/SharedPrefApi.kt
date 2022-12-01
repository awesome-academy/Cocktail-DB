package com.sildev.thecocktail.data.source.local.sharedpref

interface SharedPrefApi {
    fun getBoolean(key: String) : Boolean
    fun setBoolean(key: String, value: Boolean)
}
