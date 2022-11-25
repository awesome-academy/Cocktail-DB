package com.sildev.thecocktail.data.source

import com.sildev.thecocktail.data.model.Category

interface CategoryDataSource {
    interface Remote {
        suspend fun getCategory(): List<Category>
    }
}
