package com.lospythones.mobilemisiontic2022.data.remote


import com.lospythones.mobilemisiontic2022.model.POIModel
import retrofit2.http.GET


interface ApiService {

    @GET("pois")
    suspend fun requestPois(): List<POIModel>

}
