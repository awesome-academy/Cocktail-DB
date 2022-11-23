package com.sildev.thecocktail.utils.extension

import android.view.View
import androidx.core.view.isVisible

fun View.setVisible() {
    if (!isVisible) {
        isVisible = true
    }
}

fun View.setInvisible() {
    if (isVisible) {
        isVisible = false
    }
}
