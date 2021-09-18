package com.lospythones.mobilemisiontic2022.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.lospythones.mobilemisiontic2022.R
import com.lospythones.mobilemisiontic2022.model.POI

class ItemAdapter(private val context: Context, private val dataset: List<POI>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val photoPOI: ImageView = view.findViewById(R.id.img_poi_list)
        val namePOI: TextView = view.findViewById(R.id.name_poi_list)
        val locationPOI: TextView = view.findViewById(R.id.location_poi_list)
        val ratingPOI: TextView = view.findViewById(R.id.rating_poi_list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        val uri = "@drawable/${item.img}"
        val imageResource = context.resources.getIdentifier(uri, null, context.packageName)
        val resource = AppCompatResources.getDrawable(context, imageResource)

        holder.photoPOI.setImageDrawable(resource)
        holder.namePOI.text = item.name
        holder.locationPOI.text = item.location
        holder.ratingPOI.text = item.rating
    }

    override fun getItemCount() = dataset.size
}