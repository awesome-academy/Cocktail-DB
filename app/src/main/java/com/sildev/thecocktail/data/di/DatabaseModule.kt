package com.sildev.thecocktail.data.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.sildev.thecocktail.data.source.local.DrinkDatabase
import com.sildev.thecocktail.data.source.local.sharedpref.SharedPrefApi
import com.sildev.thecocktail.data.source.local.sharedpref.SharedPrefImplement
import org.koin.dsl.module

val databaseModule = module {
    single { provideDrinkDatabase(get()) }
    single { provideDrinkDAO(get()) }
    single { provideSearchDAO(get()) }
    single { provideSharedPrefs(get()) }
}

private fun provideDrinkDatabase(context: Context): DrinkDatabase {
    return Room.databaseBuilder(
        context.applicationContext, DrinkDatabase::class.java, DrinkDatabase.DATABASE_NAME
    ).build()
}

private fun provideDrinkDAO(drinkDatabase: DrinkDatabase) = drinkDatabase.getDrinkDAO()
private fun provideSearchDAO(drinkDatabase: DrinkDatabase) = drinkDatabase.getSearchDAO()
private fun provideSharedPrefs(app: Application): SharedPrefApi = SharedPrefImplement(app)
