package com.sildev.thecocktail.utils.extension

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.replaceFragment(
    containerId: Int,
    fragment: Fragment,
    isAddBackStack: Boolean = true
) {
    supportFragmentManager.beginTransaction().apply {
        replace(containerId, fragment)
        if (isAddBackStack) {
            addToBackStack(null)
        }
        commit()
    }
}
