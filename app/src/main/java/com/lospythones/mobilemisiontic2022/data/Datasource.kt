package com.lospythones.mobilemisiontic2022.data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lospythones.mobilemisiontic2022.model.POI


class Datasource {
    fun loadPOIs(jsonString: String): List<POI> {
        val gson = Gson()
        val listPOIType = object : TypeToken<List<POI>>() {}.type

        return gson.fromJson(jsonString, listPOIType)

        // return listOf(Json.decodeFromString(jsonString))

        // return gson.fromJson(jsonString, listPOIType);
        /*return listOf(
            POI(
                R.drawable.versailles_0,
                R.string.poi_name,
                R.string.poi_location,
                R.string.poi_value
            ),
            POI(
                R.drawable.versailles_0,
                R.string.poi_name,
                R.string.poi_location,
                R.string.poi_value
            ),
            POI(
                R.drawable.versailles_0,
                R.string.poi_name,
                R.string.poi_location,
                R.string.poi_value
            ),
            POI(
                R.drawable.versailles_0,
                R.string.poi_name,
                R.string.poi_location,
                R.string.poi_value
            )
        )*/
    }
}