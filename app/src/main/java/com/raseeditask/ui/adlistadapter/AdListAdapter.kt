package com.raseeditask.ui.adlistadapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raseeditask.R
import com.raseeditask.data.adresponse.AdModel
import com.squareup.picasso.Callback
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_item.view.*


class AdListAdapter : RecyclerView.Adapter<AdListAdapter.DataViewHolder>() {

    private val adList: ArrayList<AdModel>?
    private lateinit var context: Context

    init {
        this.adList = ArrayList()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        context = parent.context
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.card_item, parent, false)
        return DataViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val adModel = adList!![position]
        holder.adTitle!!.setText(adModel.title)
        downloadImageAndCashItInOfflineMode(adModel, holder)
        holder.itemView!!.setOnClickListener {
            openExternalWebBrowser(adModel.url)
        }
    }

    fun setAdList(adModelList: List<AdModel>) {
        if (adList == null) {
            return
        }
        adList.clear()
        adList.addAll(adModelList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return adList!!.size
    }

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val adTitle = itemView.ad_title
        val adImage = itemView.ad_image
    }

    private fun downloadImageAndCashItInOfflineMode(adModel: AdModel, holder: DataViewHolder) {
        Picasso.get()
                .load(adModel.picture)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .fit()
                .into(holder.adImage!!, object : Callback {
                    override fun onSuccess() {

                    }

                    override fun onError(e: Exception) {
                        Picasso.get()
                                .load(adModel.picture)
                                .placeholder(ColorDrawable(Color.BLACK))
                                .into(holder.adImage)
                    }
                })
    }

    private fun openExternalWebBrowser(url: String) {
        val openURL = Intent(Intent.ACTION_VIEW)
        openURL.data = Uri.parse(url)
        context.startActivity(openURL)
    }
}
