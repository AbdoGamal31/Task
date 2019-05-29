package com.raseeditask.data.adrepository

import android.content.Context
import com.raseeditask.data.adnetwork.NetworkUtility
import com.raseeditask.data.adresponse.AdModel
import com.raseeditask.data.adusecase.GetLocalAdAscendingOrderUseCase
import com.raseeditask.data.adusecase.GetRemoteAdAscendingOrderUseCase
import io.reactivex.Observable

class AdRepository(
        private val context: Context,
        private val getRemoteAdAscendingOrderUseCase: GetRemoteAdAscendingOrderUseCase,
        private val getLocalAdAscendingOrderUseCase: GetLocalAdAscendingOrderUseCase
) {

    var isConnectedNetwork = NetworkUtility(context).isOnline()

    fun getAdAscendingOrder(): Observable<MutableList<AdModel>>? {
        if (isConnectedNetwork)
            return getRemoteAdAscendingOrderUseCase.getAdAscendingOrder()
        else return getLocalAdAscendingOrderUseCase.getAdAscendingOrder()
    }
}