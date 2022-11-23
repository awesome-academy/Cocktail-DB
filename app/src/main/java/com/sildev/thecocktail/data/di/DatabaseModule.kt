package com.sildev.thecocktail.data.di

import android.content.Context
import androidx.room.Room
import com.sildev.thecocktail.data.source.local.DrinkDatabase
import org.koin.dsl.module

val databaseModule = module {
    single { provideDrinkDatabase(get()) }
    single { provideDrinkDAO(get()) }
    single { provideSearchDAO(get()) }
}

private fun provideDrinkDatabase(context: Context): DrinkDatabase {
    return Room.databaseBuilder(
        context.applicationContext, DrinkDatabase::class.java, DrinkDatabase.DATABASE_NAME
    ).build()
}

private fun provideDrinkDAO(drinkDatabase: DrinkDatabase) = drinkDatabase.getDrinkDAO()
private fun provideSearchDAO(drinkDatabase: DrinkDatabase) = drinkDatabase.getSearchDAO()
