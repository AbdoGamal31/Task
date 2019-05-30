package com.raseeditask.data.adusecase

import com.raseeditask.data.addatastore.RemoteAdDataStore
import com.raseeditask.data.addatastore.localstore.LocalAdDataStore
import com.raseeditask.data.adresponse.AdModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * this class use for do any operations on data like sort delete or filter based on any type
 * and store data into DB
 *@param private val remoteAdDataStore: RemoteAdDataStore
 *@param  private val localAdDataStore: LocalAdDataStore
 *  @author  Abdo Gamal
 * @version 1.0
 * @since   27-5-2019
 */
class GetRemoteAdAscendingOrderUseCase(
    private val remoteAdDataStore: RemoteAdDataStore
    , private val localAdDataStore: LocalAdDataStore
) {
//here i get data from api and sort it in ascending order  and also store data into DB
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