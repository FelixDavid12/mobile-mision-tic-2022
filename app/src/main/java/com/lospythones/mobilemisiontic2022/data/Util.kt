package com.lospythones.mobilemisiontic2022.data

import android.content.Context
import java.io.IOException

class Util {
    fun getJsonDataFromAsset(context: Context, fileName: String): String {
        var jsonString = ""

        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
        }

        return jsonString
    }
}