package com.raseeditask.ui.adlist

import androidx.lifecycle.ViewModel;
import com.raseeditask.data.adrepository.AdRepository
import com.raseeditask.data.adresponse.AdModel
import io.reactivex.Observable

/**
 * this class response for getting data from repo
 * @param  private val adRepository: AdRepository
 *  @author  Abdo Gamal
 * @version 1.0
 * @since   27-5-2019
 */
class AdPageViewModel(private val adRepository: AdRepository) : ViewModel() {

    fun getAdAscendingOrder(): Observable<MutableList<AdModel>>? {
        return adRepository.getAdAscendingOrder()
    }
}
