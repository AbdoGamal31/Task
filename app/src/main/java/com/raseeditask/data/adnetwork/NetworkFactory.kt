package com.raseeditask.data.adresponse

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * use this class to create object from retrofit to make calls to an api and get result
 * @author  Abdo Gamal
 * @version 1.0
 * @since   27-5-2019
 */
const val BASE_URL = "https://simswitch.bit68.com/"

object NetworkFactory {

    operator fun invoke(): AdApis {
        val okHttp = OkHttpClient.Builder()
            .build()
//here build retrofit object a
        return Retrofit.Builder()
            .client(okHttp)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AdApis::class.java)
    }
}