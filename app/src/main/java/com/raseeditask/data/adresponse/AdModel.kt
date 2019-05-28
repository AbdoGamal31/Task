package com.raseeditask.data.adresponse


import com.google.gson.annotations.SerializedName

data class AdModel(
    @SerializedName("action")
    val action: String,
    @SerializedName("best_offer")
    val bestOffer: Boolean,
    @SerializedName("order")
    val order: Int,
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
)