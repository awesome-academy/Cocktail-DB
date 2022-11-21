package com.sildev.thecocktail.base

import com.sildev.thecocktail.utils.DataResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class BaseRepository {

    suspend fun <T> getResult(request: suspend CoroutineScope.() -> T): DataResult<T> {
        return withContext(Dispatchers.IO) {
            try {
                DataResult.Success(request())
            } catch (e: IOException) {
                DataResult.Error(e)
            }
        }
    }
}
