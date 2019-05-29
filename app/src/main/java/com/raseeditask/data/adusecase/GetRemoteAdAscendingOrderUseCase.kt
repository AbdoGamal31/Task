package com.raseeditask.data.adusecase

import com.raseeditask.data.addatastore.localstore.LocalAdDataStore
import com.raseeditask.data.addatastore.RemoteAdDataStore
import com.raseeditask.data.adresponse.AdModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetRemoteAdAscendingOrderUseCase(private val remoteAdDataStore: RemoteAdDataStore
                                       , private val localAdDataStore: LocalAdDataStore
) {

    fun getAdAscendingOrder(): Observable<MutableList<AdModel>>? {
        return remoteAdDataStore.getAd()
                .flatMapIterable { t: List<AdModel> -> t }
                .toSortedList().toObservable()
                .onErrorReturnItem(emptyList())
                .doOnNext { localAdDataStore.insert(it) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }
}