package com.sildev.thecocktail.data.source.local.sharedpref

import android.content.Context
import com.sildev.thecocktail.data.source.local.sharedpref.SharedPrefKey.BOOLEAN_DEFAULT

class SharedPrefImplement(context: Context) : SharedPrefApi {

    private val sharedPreferences by lazy {
        context.getSharedPreferences(SharedPrefKey.PREFS_NAME, Context.MODE_PRIVATE)
    }

    override fun getBoolean(key: String): Boolean =
        sharedPreferences.getBoolean(key, BOOLEAN_DEFAULT)

    override fun setBoolean(key: String, value: Boolean) {
        val edit = sharedPreferences.edit()
        edit.putBoolean(key, value)
        edit.apply()
    }
}
