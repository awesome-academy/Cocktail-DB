package com.sildev.thecocktail.base

import android.content.Context
import android.content.ContextWrapper
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.sildev.thecocktail.data.source.local.sharedpref.SharedPrefApi
import com.sildev.thecocktail.data.source.local.sharedpref.SharedPrefKey
import com.sildev.thecocktail.utils.Constant
import com.sildev.thecocktail.utils.NetworkUtils
import com.sildev.thecocktail.utils.extension.setAppLocale
import com.sildev.thecocktail.utils.extension.showToast
import org.koin.android.ext.android.inject

typealias Inflate<T> = (LayoutInflater) -> T

abstract class BaseActivity<T : ViewBinding>(private val inflater: Inflate<T>) :
    AppCompatActivity() {

    protected val binding: T by lazy { inflater(layoutInflater) }
    abstract val viewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.error.observe(this) {
            showToast(it)
        }
        setUpListenerNetwork()
        checkInternet()
    }

    override fun attachBaseContext(newBase: Context) {
        val sharedPref: SharedPrefApi by inject()
        if (sharedPref.getBoolean(SharedPrefKey.KEY_LANGUAGE)) {
            super.attachBaseContext(
                ContextWrapper(newBase.setAppLocale(Constant.ENGLISH_LANGUAGE_CODE))
            )
        } else {
            super.attachBaseContext(
                ContextWrapper(newBase.setAppLocale(Constant.VIETNAMESE_LANGUAGE_CODE))
            )
        }
    }

    private fun setUpListenerNetwork() {
        val alertDialog = NetworkUtils.getNetworkAlertDialog(this).create()
        val networkCallback = object : ConnectivityManager.NetworkCallback() {

            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                alertDialog.dismiss()
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                runOnUiThread {
                    alertDialog.show()
                }
            }
        }
        val networkRequest =
            NetworkRequest.Builder().addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
                .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR).build()

        val connectivityManager =
            getSystemService(ConnectivityManager::class.java) as ConnectivityManager
        connectivityManager.requestNetwork(networkRequest, networkCallback)
    }

    private fun checkInternet() {
        if (NetworkUtils.isConnectedToInternet(this).not()) {
            NetworkUtils.getNetworkAlertDialog(this).show()
        }
    }
}
