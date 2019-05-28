package com.raseeditask.data.adrepository

import com.raseeditask.data.addatastore.LocalAdDataStore
import com.raseeditask.data.addatastore.RemoteAdDataStore

class AdRepository(
    private val remoteAdDataStore: RemoteAdDataStore,
    private val localAdDataStore: LocalAdDataStore
) {
}