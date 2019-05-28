package com.raseeditask.data.adusecase

import com.raseeditask.data.addatastore.RemoteAdDataStore
import com.raseeditask.data.adresponse.AdModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetRemoteAdAscendingOrderUseCase(private val remoteAdDataStore: RemoteAdDataStore) {

    fun getAdAscendingOrder(): Single<MutableList<MutableList<AdModel>>>? {
        return remoteAdDataStore.getAd()
            .flatMapIterable { t: List<AdModel> -> t }
            .toSortedList().toObservable().toList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}