package com.raseeditask.data.adresponse


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "ad_table")
data class AdModel(
    @SerializedName("action")
    val action: String,
    @SerializedName("best_offer")
    val bestOffer: Boolean,
    @SerializedName("order")
    val order: Int,
    @PrimaryKey
    @SerializedName("picture")
    val picture: String,
    @SerializedName("solo")
    val solo: Boolean,
    @SerializedName("sucess")
    val sucess: Boolean,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
) : Comparable<AdModel> {

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override operator fun compareTo(o: AdModel): Int {
        return Integer.compare(this.order, o.order)
    }


}