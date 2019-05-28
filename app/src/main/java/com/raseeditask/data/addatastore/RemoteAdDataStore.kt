package com.raseeditask.data.addatastore

import com.raseeditask.data.adresponse.AdApis
import com.raseeditask.data.adresponse.AdModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RemoteAdDataStore(
    private val adApis: AdApis
) {

     fun getAd(): Observable<List<AdModel>> {
        return adApis.getAd()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}