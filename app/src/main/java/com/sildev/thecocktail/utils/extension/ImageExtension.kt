package com.sildev.thecocktail.utils.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.sildev.thecocktail.R

fun ImageView.loadImage(url: String) {
    Glide.with(context).load(url)
        .error(R.drawable.cocktail)
        .placeholder(R.drawable.cocktail)
        .into(this)
}
