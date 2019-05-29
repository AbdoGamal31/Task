package com.raseeditask.data.addatastore

import com.raseeditask.data.addatastore.adcashing.AdDao
import com.raseeditask.data.adresponse.AdModel

class LocalAdDataStore(private val adDao: AdDao) {

    fun getAd(): MutableList<AdModel> {
        return adDao.getAdAscendingOrder()
    }

    fun insert(adList: MutableList<AdModel>) {
        return adDao.insert(adList)
    }
}