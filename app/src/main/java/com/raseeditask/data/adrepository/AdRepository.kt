package com.raseeditask.data.adrepository

import android.content.Context
import com.raseeditask.data.adnetwork.NetworkUtility
import com.raseeditask.data.adresponse.AdModel
import com.raseeditask.data.adusecase.GetLocalAdAscendingOrderUseCase
import com.raseeditask.data.adusecase.GetRemoteAdAscendingOrderUseCase
import io.reactivex.Observable

/**
 * this class use decide where i will get list of Ad from remote or local store
 *@param  private val context: Context,
 *@param private val getRemoteAdAscendingOrderUseCase: GetRemoteAdAscendingOrderUseCase,
 *@param private val getLocalAdAscendingOrderUseCase: GetLocalAdAscendingOrderUseCase
 * @author  Abdo Gamal
 * @version 1.0
 * @since   28-5-2019
 */
class AdRepository(
    private val context: Context,
    private val getRemoteAdAscendingOrderUseCase: GetRemoteAdAscendingOrderUseCase,
    private val getLocalAdAscendingOrderUseCase: GetLocalAdAscendingOrderUseCase
) {
//here check if there is connection
    var isConnectedNetwork = NetworkUtility(context).isOnline()
    /**
     * here i check if there is network connection get data from Api
     * if there is no connection get data from DB
     * @version 1.0
     * @since   27-5-2019
     */
    fun getAdAscendingOrder(): Observable<MutableList<AdModel>>? {
        if (isConnectedNetwork)
            return getRemoteAdAscendingOrderUseCase.getAdAscendingOrder()
        else return getLocalAdAscendingOrderUseCase.getAdAscendingOrder()
    }
}