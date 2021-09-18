package com.lospythones.mobilemisiontic2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.lospythones.mobilemisiontic2022.adapter.ItemAdapter
import com.lospythones.mobilemisiontic2022.data.Datasource
import com.lospythones.mobilemisiontic2022.data.Util

class FelixPOIsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_felix_pois)

        // Read JSON from file and save as a String in a variable
        val jsonString = Util().getJsonDataFromAsset(this, "mock_poi.json")

        // Load the JSON string as a Kotlin object
        val pois = Datasource().loadPOIs(jsonString)

        // Find the Recycler View related to the current class
        val view = findViewById<RecyclerView>(R.id.felix_pois_list)

        // Load adapter in the Recycler View with the pois from the JSON File
        view.adapter = ItemAdapter(this, pois)
    }

}