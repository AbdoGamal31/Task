package com.raseeditask.data.adusecase

import com.raseeditask.data.addatastore.localstore.LocalAdDataStore
import com.raseeditask.data.adresponse.AdModel
import io.reactivex.Observable

/**
 * this class use for do any operations on data like sort delete or filter based on any type
 *@param  private val localAdDataStore: LocalAdDataStore
 * @author  Abdo Gamal
 * @version 1.0
 * @since   28-5-2019
 */
class GetLocalAdAscendingOrderUseCase(private val localAdDataStore: LocalAdDataStore) {

    fun getAdAscendingOrder(): Observable<MutableList<AdModel>> {
        return localAdDataStore.getAd()
    }
}