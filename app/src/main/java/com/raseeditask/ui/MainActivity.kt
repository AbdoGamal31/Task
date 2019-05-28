package com.raseeditask.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.raseeditask.R
import com.raseeditask.data.addatastore.RemoteAdDataStore
import com.raseeditask.data.adresponse.NetworkFactory
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer

class MainActivity : AppCompatActivity() {
    lateinit var disposable: Disposable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val remoteAdDataStore: RemoteAdDataStore = RemoteAdDataStore(adApis = NetworkFactory())

        disposable = remoteAdDataStore.getAd().subscribe(Consumer {  Log.d("data", it.toString()) }, Consumer {  Log.d("data", it.toString()) })
    }
}
