package com.raseeditask.data.adnetwork

import android.content.Context
import android.net.ConnectivityManager

/**
 * this class use for network utility
 *@param private val context: Context
 * @author  Abdo Gamal
 * @version 1.0
 * @since   28-5-2019
 */
class NetworkUtility(private val context: Context) {

    val appContext = context.applicationContext
    //check if there is internet connection or not
    fun isOnline(): Boolean {
        val connectivityManager = appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}