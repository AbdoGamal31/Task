package com.raseeditask.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.raseeditask.R
import com.raseeditask.data.addatastore.RemoteAdDataStore
import com.raseeditask.data.adresponse.NetworkFactory
import com.raseeditask.data.adusecase.GetRemoteAdAscendingOrderUseCase
import com.raseeditask.ui.adlistadapter.AdListAdapter
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.ad_page.*

class AdPage : Fragment() {

    private lateinit var viewModel: AdPageViewModel
    lateinit var disposable: Disposable
    lateinit var adapter: AdListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.ad_page, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AdPageViewModel::class.java)
        // TODO: Use the ViewModel
        val remoteAdDataStore = RemoteAdDataStore(adApis = NetworkFactory())
        val getAdAscendingOrderUseCase = GetRemoteAdAscendingOrderUseCase(remoteAdDataStore)
        adapter= AdListAdapter()
        disposable =
            getAdAscendingOrderUseCase.getAdAscendingOrder()!!
                .subscribe( Consumer {
                    group_loading.visibility=View.GONE
                    ad_card_list.visibility=View.VISIBLE
                    ad_card_list.layoutManager= LinearLayoutManager(activity)
                    ad_card_list.adapter=adapter
                    ad_card_list.hasFixedSize()
                    adapter.setAdList(it)
                    adapter.notifyDataSetChanged()
                },
                Consumer { Log.d("data", it.toString()) })
    }

}
