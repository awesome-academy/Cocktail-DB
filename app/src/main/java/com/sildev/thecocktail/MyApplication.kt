package com.sildev.thecocktail

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.sildev.thecocktail.data.di.DataSourceModule
import com.sildev.thecocktail.data.di.RepositoryModule
import com.sildev.thecocktail.data.di.databaseModule
import com.sildev.thecocktail.data.di.networkModule
import com.sildev.thecocktail.data.source.local.sharedpref.SharedPrefApi
import com.sildev.thecocktail.data.source.local.sharedpref.SharedPrefKey
import com.sildev.thecocktail.di.ViewModelModule
import com.sildev.thecocktail.di.fragmentModule
import com.sildev.thecocktail.utils.Constant
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import java.util.Locale

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val modules = listOf(
            networkModule,
            databaseModule,
            DataSourceModule,
            RepositoryModule,
            ViewModelModule,
            fragmentModule
        )

        startKoin {
            androidContext(this@MyApplication)
            modules(modules)
        }
        val sharedPref: SharedPrefApi by inject()
        val isFirstTime = sharedPref.getBoolean(SharedPrefKey.KEY_FIRST_TIME)
        if (isFirstTime.not()) {
            val languageCode = Locale.getDefault().language
            if (languageCode.equals(Constant.VIETNAMESE_LANGUAGE_CODE, true)) {
                sharedPref.setBoolean(SharedPrefKey.KEY_LANGUAGE, false)
            } else {
                sharedPref.setBoolean(SharedPrefKey.KEY_LANGUAGE, true)
            }
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            sharedPref.setBoolean(SharedPrefKey.KEY_NIGHT_MODE, false)
            sharedPref.setBoolean(SharedPrefKey.KEY_FIRST_TIME, true)
        } else {
            if (sharedPref.getBoolean(SharedPrefKey.KEY_NIGHT_MODE)) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

    }
}
