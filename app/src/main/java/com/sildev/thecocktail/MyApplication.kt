package com.sildev.thecocktail

import android.app.Application
import com.sildev.thecocktail.data.di.DataSourceModule
import com.sildev.thecocktail.data.di.RepositoryModule
import com.sildev.thecocktail.data.di.databaseModule
import com.sildev.thecocktail.data.di.networkModule
import com.sildev.thecocktail.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val modules = listOf(
            networkModule,
            databaseModule,
            DataSourceModule,
            RepositoryModule,
            ViewModelModule,
            )

        startKoin {
            androidContext(this@MyApplication)
            modules(modules)
        }
    }
}
