package com.raseeditask.data.adresponse

import io.reactivex.Observable
import retrofit2.http.GET

interface AdApis {

    @GET("get_ad/?solo=false")
    fun getAd(): Observable<List<AdModel>>
}