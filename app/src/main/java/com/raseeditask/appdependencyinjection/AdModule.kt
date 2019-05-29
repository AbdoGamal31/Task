package com.raseeditask.appdependencyinjection

import android.app.Application
import com.raseeditask.data.addatastore.RemoteAdDataStore
import com.raseeditask.data.addatastore.localstore.AppDatabase
import com.raseeditask.data.addatastore.localstore.LocalAdDataStore
import com.raseeditask.data.adrepository.AdRepository
import com.raseeditask.data.adresponse.NetworkFactory
import com.raseeditask.data.adusecase.GetLocalAdAscendingOrderUseCase
import com.raseeditask.data.adusecase.GetRemoteAdAscendingOrderUseCase
import com.raseeditask.ui.adlist.AdPageViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class AdModule : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@AdModule))
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { instance<AppDatabase>().adDao() }
        bind() from singleton { NetworkFactory() }
        bind() from singleton { RemoteAdDataStore(instance()) }

        bind() from singleton { LocalAdDataStore(instance()) }
        bind() from provider { GetLocalAdAscendingOrderUseCase(instance()) }
        bind() from provider { GetRemoteAdAscendingOrderUseCase(instance(), instance()) }
        bind() from provider { AdRepository(instance(), instance(), instance()) }
        bind() from provider { AdPageViewModelFactory(instance()) }
    }

}