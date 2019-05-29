package com.raseeditask.ui.adlistadapter

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
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

    init {
        this.adList = ArrayList()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item, parent, false)

        return DataViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val adModel = adList!![position]
        holder.adTitle!!.setText(adModel.title)
        Picasso.get()
            .load(adModel.picture)
            .networkPolicy(NetworkPolicy.OFFLINE)
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
        holder.itemView!!.setOnClickListener({ v ->

        })
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
}
