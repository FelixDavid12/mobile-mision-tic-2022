package com.lospythones.mobilemisiontic2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.lospythones.mobilemisiontic2022.adapter.ItemAdapter
import com.lospythones.mobilemisiontic2022.data.Datasource
import com.lospythones.mobilemisiontic2022.data.Util

class RecyclerAnActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_an_main)

        val jsonString = Util().getJsonDataFromAsset(this, "mock_poi.json")

        val poiDataset = Datasource().loadPOIs(jsonString)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.adapter = ItemAdapter(this, poiDataset)
    }
}