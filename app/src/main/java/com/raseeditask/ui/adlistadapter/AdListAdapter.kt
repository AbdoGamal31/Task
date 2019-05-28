package com.raseeditask.ui.adlistadapter

import androidx.recyclerview.widget.RecyclerView
import android.R
import android.widget.TextView
import android.text.method.TextKeyListener.clear
import android.graphics.Movie
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior.setTag
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.raseeditask.data.adresponse.AdModel


class AdListAdapter : RecyclerView.Adapter<AdListAdapter.DataViewHolder>() {

    private val adList: ArrayList<AdModel>?

    init {
        this.adList = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.ad_list_item, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder( holder: DataViewHolder, position: Int) {
        val adModel = adList!![position]
        holder.movieName!!.setText(movie.getOriginalTitle())
        holder.movieOverview!!.setText(movie.getOverview())
        holder.movieReleaseDate!!.setText(movie.getReleaseDate())
        holder.favIcon!!.setOnClickListener({ v ->

        })
    }


    fun setTopRatedMovieList(movieList: List<Movie>) {
        if (movies == null) {
            return
        }
        movies.clear()
        movies.addAll(movieList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return movies!!.size()
    }

    internal inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvAnimalType = view.

    }
}
