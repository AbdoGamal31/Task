package com.raseeditask.ui.adlist

import androidx.lifecycle.ViewModel;
import com.raseeditask.data.adrepository.AdRepository
import com.raseeditask.data.adresponse.AdModel
import io.reactivex.Observable

class AdPageViewModel(private val adRepository: AdRepository) : ViewModel() {

    fun getAdAscendingOrder(): Observable<MutableList<AdModel>>? {
        return adRepository.getAdAscendingOrder()
    }
}
