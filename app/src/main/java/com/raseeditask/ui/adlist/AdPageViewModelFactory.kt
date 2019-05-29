package com.raseeditask.ui.adlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.raseeditask.data.adrepository.AdRepository

class AdPageViewModelFactory(
    private val adRepository: AdRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AdPageViewModel(adRepository) as T
    }
}