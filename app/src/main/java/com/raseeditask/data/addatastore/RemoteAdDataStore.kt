package com.raseeditask.data.addatastore

import com.raseeditask.data.adresponse.AdApis
import com.raseeditask.data.adresponse.AdModel
import io.reactivex.Observable

/**
 * this class use for get list of Ad from Api (from remote store)
 *@param private val adApis: AdApis
 * @author  Abdo Gamal
 * @version 1.0
 * @since   28-5-2019
 */
class RemoteAdDataStore(private val adApis: AdApis) {

    fun getAd(): Observable<List<AdModel>> {
        return adApis.getAd()

    }
}