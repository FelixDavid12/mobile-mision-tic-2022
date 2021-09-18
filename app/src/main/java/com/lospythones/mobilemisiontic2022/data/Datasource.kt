package com.lospythones.mobilemisiontic2022.data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lospythones.mobilemisiontic2022.model.POI


class Datasource {
    fun loadPOIs(jsonString: String): List<POI> {
        val gson = Gson()
        val listPOIType = object : TypeToken<List<POI>>() {}.type

        return gson.fromJson(jsonString, listPOIType)
    }
}