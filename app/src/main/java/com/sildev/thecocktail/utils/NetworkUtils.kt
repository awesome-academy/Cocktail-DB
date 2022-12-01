package com.sildev.thecocktail.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AlertDialog
import com.sildev.thecocktail.R

object NetworkUtils {

    fun isConnectedToInternet(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = connectivityManager.allNetworkInfo
        info.forEach {
            if (it.state == NetworkInfo.State.CONNECTED) return true
        }
        return false
    }

    fun getNetworkAlertDialog(context: Context): AlertDialog.Builder {
        return AlertDialog.Builder(context, R.style.AlertDialogTheme)
            .setTitle(context.getString(R.string.internet_alert))
            .setMessage(context.getString(R.string.message_internet_alert))
            .setPositiveButton(context.getString(R.string.ok)) { dialog, _ -> dialog.dismiss() }
    }
}
