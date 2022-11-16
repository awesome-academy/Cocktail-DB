package com.sildev.thecocktail.data.di

import android.content.Context
import androidx.room.Room
import com.sildev.thecocktail.data.source.local.DrinkDatabase
import com.sildev.thecocktail.data.source.local.ListConverter
import org.koin.dsl.module

val databaseModule = module {
    single { provideMealDatabase(get()) }
    single { provideMealDAO(get()) }
}

private fun provideMealDatabase(context: Context): DrinkDatabase {
    return Room.databaseBuilder(
        context.applicationContext,
        DrinkDatabase::class.java,
        DrinkDatabase.DATABASE_NAME
    ).addTypeConverter(ListConverter()).build()
}

private fun provideMealDAO(mealDatabase: DrinkDatabase) = mealDatabase.getDrinkDAO()

