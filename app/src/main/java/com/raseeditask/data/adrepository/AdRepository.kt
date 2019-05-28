package com.raseeditask.data.adrepository

import android.content.Context
import com.raseeditask.data.addatastore.LocalAdDataStore
import com.raseeditask.data.adnetwork.NetworkUtility
import com.raseeditask.data.adresponse.AdModel
import com.raseeditask.data.adusecase.GetRemoteAdAscendingOrderUseCase
import io.reactivex.Single

class AdRepository(
        private val context: Context,
        private val getRemoteAdAscendingOrderUseCase: GetRemoteAdAscendingOrderUseCase,
        private val localAdDataStore: LocalAdDataStore
) {

    var isConnectedNetwork = NetworkUtility(context).isOnline()

    fun getAdAscendingOrder(): Single<MutableList<MutableList<AdModel>>>? {
        if (isConnectedNetwork)
            return getRemoteAdAscendingOrderUseCase.getAdAscendingOrder()
        else return null
    }
}