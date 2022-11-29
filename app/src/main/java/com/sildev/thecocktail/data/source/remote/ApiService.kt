package com.sildev.thecocktail.data.source.remote

import com.sildev.thecocktail.data.model.CategoryResponse
import com.sildev.thecocktail.data.model.DrinkDetailResponse
import com.sildev.thecocktail.data.model.DrinkResponse
import com.sildev.thecocktail.data.model.IngredientResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("random.php")
    suspend fun getRandomDrink(): DrinkResponse

    @GET("filter.php?c=Cocktail")
    suspend fun getCockTailDrink(): DrinkResponse

    @GET("search.php")
    suspend fun getDrinkByName(@Query("s") name: String): DrinkResponse

    @GET("list.php?c=list")
    suspend fun getCategory(): CategoryResponse

    @GET("list.php?i=list")
    suspend fun getListIngredient(): IngredientResponse

    @GET("filter.php")
    suspend fun filterByIngredient(@Query("i") name: String): DrinkResponse

    @GET("filter.php")
    suspend fun filterByCategory(@Query("c") name: String): DrinkResponse

    @GET("lookup.php")
    suspend fun getDetailDrink(@Query("i") id: String): DrinkDetailResponse

}
