package com.raseeditask.data.adusecase

import com.raseeditask.data.addatastore.localstore.LocalAdDataStore
import com.raseeditask.data.adresponse.AdModel
import io.reactivex.Observable

class GetLocalAdAscendingOrderUseCase(private val localAdDataStore: LocalAdDataStore) {

    fun getAdAscendingOrder(): Observable<MutableList<AdModel>> {
        return localAdDataStore.getAd()
    }
}