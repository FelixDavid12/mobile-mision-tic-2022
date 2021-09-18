package com.lospythones.mobilemisiontic2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.lospythones.mobilemisiontic2022.adapter.ItemAdapter
import com.lospythones.mobilemisiontic2022.data.Datasource
import com.lospythones.mobilemisiontic2022.data.Util

class RecyclerActivityJCP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_jcp)

        // Read JSON from file and save as a String in a variable
        val jsonString = Util().getJsonDataFromAsset(this, "mock_poi.json")

        // Load the JSON string as a Kotlin object
        val list = Datasource().loadPOIs(jsonString)

        // Find the Recycler View related to the current class
        val initialview = findViewById<RecyclerView>(R.id.list_view_recyclerlist_jcp)

        // Load adapter in the Recycler View with the pois from the JSON File
        initialview.adapter = ItemAdapter(this, list)
    }
}