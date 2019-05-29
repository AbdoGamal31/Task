package com.raseeditask.ui.adlist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.raseeditask.R
import com.raseeditask.data.addatastore.RemoteAdDataStore
import com.raseeditask.data.addatastore.localstore.AdDao
import com.raseeditask.data.addatastore.localstore.AppDatabase
import com.raseeditask.data.addatastore.localstore.LocalAdDataStore
import com.raseeditask.data.adrepository.AdRepository
import com.raseeditask.data.adresponse.AdModel
import com.raseeditask.data.adresponse.NetworkFactory
import com.raseeditask.data.adusecase.GetLocalAdAscendingOrderUseCase
import com.raseeditask.data.adusecase.GetRemoteAdAscendingOrderUseCase
import com.raseeditask.ui.adlistadapter.AdListAdapter
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.ad_page.*


class AdPage : Fragment() {

    private lateinit var viewModel: AdPageViewModel
    private lateinit var disposable: Disposable
    private lateinit var adapter: AdListAdapter
    private var adDao: AdDao? = null
    private lateinit var adPageViewModelFactory: AdPageViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.ad_page, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        changePageTtitle()
        val remoteAdDataStore = RemoteAdDataStore(adApis = NetworkFactory())
        adDao = AppDatabase.invoke(context!!).adDao()
        val getAdAscendingOrderUseCaseRemote =
            GetRemoteAdAscendingOrderUseCase(
                remoteAdDataStore,
                LocalAdDataStore(adDao!!)
            )
        val getAdAscendingOrderUseCaseLocal =
            GetLocalAdAscendingOrderUseCase(
                localAdDataStore = LocalAdDataStore(
                    adDao!!
                )
            )

        adPageViewModelFactory = AdPageViewModelFactory(
            AdRepository(
                context!!,
                getAdAscendingOrderUseCaseRemote,
                getAdAscendingOrderUseCaseLocal
            )
        )

        viewModel = ViewModelProviders.of(this, adPageViewModelFactory).get(AdPageViewModel::class.java)
        adapter = AdListAdapter()

        disposable = viewModel.getAdAscendingOrder()!!
            .subscribe(Consumer {
                displayAdListIntoRecView(it)
            }, Consumer { Log.d("data", it.toString()) })
    }

    private fun displayAdListIntoRecView(it: MutableList<AdModel>) {
        if (it.size == 0) {
            empty_stat.visibility = View.VISIBLE
            group_loading.visibility = View.GONE
            ad_card_list.visibility = View.GONE
        } else {
            group_loading.visibility = View.GONE
            ad_card_list.visibility = View.VISIBLE
            ad_card_list.layoutManager = LinearLayoutManager(activity)
            ad_card_list.adapter = adapter
            ad_card_list.hasFixedSize()
            adapter.setAdList(it)
            adapter.notifyDataSetChanged()
        }
    }

    private fun changePageTtitle() {
        (activity as? AppCompatActivity)?.supportActionBar?.title = "Advertisements"
        (activity as? AppCompatActivity)?.supportActionBar?.subtitle = null
    }

    override fun onStop() {
        super.onStop()
        if (!disposable.isDisposed) disposable.dispose()
    }
}
