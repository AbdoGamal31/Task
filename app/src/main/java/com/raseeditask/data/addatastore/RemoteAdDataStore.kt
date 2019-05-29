package com.raseeditask.data.addatastore

import com.raseeditask.data.adresponse.AdApis
import com.raseeditask.data.adresponse.AdModel
import com.raseeditask.data.adresponse.NetworkFactory
import io.reactivex.Observable

class RemoteAdDataStore(
    private val adApis: AdApis
) {

    fun getAd(): Observable<List<AdModel>> {
        return adApis.getAd()

    }
}