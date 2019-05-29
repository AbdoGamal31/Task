package com.raseeditask.data.adusecase

import com.raseeditask.data.addatastore.localstore.LocalAdDataStore
import com.raseeditask.data.adresponse.AdModel

class GetLocalAdAscendingOrderUseCase(private val localAdDataStore: LocalAdDataStore) {

    fun getAdAscendingOrder(): MutableList<AdModel> {
        return localAdDataStore.getAd()
    }
}