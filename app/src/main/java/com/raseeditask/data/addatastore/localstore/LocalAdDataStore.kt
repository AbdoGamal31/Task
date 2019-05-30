package com.raseeditask.data.addatastore.localstore

import com.raseeditask.data.adresponse.AdModel
import io.reactivex.Observable

/**
 * this class use for get and save data into DB (from local store)
 *@param private val adDao: AdDao
 * @author  Abdo Gamal
 * @version 1.0
 * @since   28-5-2019
 */
class LocalAdDataStore(private val adDao: AdDao) {
    //here get list of Ad from DB
    fun getAd(): Observable<MutableList<AdModel>> {
        return adDao.getAdAscendingOrder()
    }

    //here insert list of Ad into DB
    fun insert(adList: MutableList<AdModel>) {
        return adDao.insert(adList)
    }
}