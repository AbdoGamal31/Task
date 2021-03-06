package com.raseeditask.ui.adlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.raseeditask.data.adrepository.AdRepository

/**
 * this class response for creating new instance of AdPageViewModel
 * @param  private val adRepository: AdRepository
 *  @author  Abdo Gamal
 * @version 1.0
 * @since   27-5-2019
 */
class AdPageViewModelFactory(
    private val adRepository: AdRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AdPageViewModel(adRepository) as T
    }
}