package com.raseeditask.data.adnetwork

import android.content.Context
import android.net.ConnectivityManager

class NetworkUtility(context: Context) {

    val appContext = context.applicationContext

    fun isOnline(): Boolean {
        val connectivityManager = appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}