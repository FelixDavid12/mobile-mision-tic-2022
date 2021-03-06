package com.lospythones.mobilemisiontic2022.model

import com.google.android.gms.maps.model.LatLng
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class POIModel(
    @SerializedName("name")
    val name: String,

    @SerializedName("location")
    val location: String,

    @SerializedName("rating")
    val rating: String,

    @SerializedName("img")
    val img: String,

    @SerializedName("detail")
    val detail: String,

    @SerializedName("gallery")
    val gallery: List<String>,

    @SerializedName("long")
    val long: Double,

    @SerializedName("lat")
    val lat: Double

) : Serializable