package com.lospythones.mobilemisiontic2022

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.FragmentManager.findFragment
import androidx.fragment.app.findFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.lospythones.mobilemisiontic2022.databinding.FragmentDetailBinding
import com.lospythones.mobilemisiontic2022.model.POIModel

class DetailFragment : Fragment() {
    companion object {
        const val POI_SELECTED = "poi"
    }

    private var poiInfo: POIModel? = null

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            poiInfo = it.getSerializable(POI_SELECTED) as POIModel?
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.poiName.text = poiInfo?.name
        binding.poiLocation.text = poiInfo?.location
        binding.poiDescription.text = poiInfo?.detail
        binding.poiValue.text = poiInfo?.rating

        binding.mainImageView.setImageDrawable(getImage(1))
        binding.imageButton3.setImageDrawable(getImage(1))
        binding.imageButton4.setImageDrawable(getImage(2))
        binding.imageButton5.setImageDrawable(getImage(3))
        binding.imageButton6.setImageDrawable(getImage((4)))
        (requireActivity() as MainActivity).title = binding.poiName.text
        val map = childFragmentManager.findFragmentById(R.id.map_fragment) as? SupportMapFragment
        map?.getMapAsync {googleMap -> addMarker(googleMap)}

    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }

    private fun getImage(index: Int): Drawable? {
        val context = requireContext()

        val uri = "@drawable/${poiInfo?.gallery?.get(index)}"
        val imageResource = context.resources.getIdentifier(uri, null, context.packageName)

        return AppCompatResources.getDrawable(context, imageResource)
    }

    /**
     * Adds marker representations of the places list on the provided GoogleMap object
     */
    private fun addMarker(googleMap: GoogleMap) {
        val position = LatLng(poiInfo?.lat!!, poiInfo?.long!!)
        val marker = googleMap.addMarker(MarkerOptions()
            .title(poiInfo?.name)
            .position(position).flat(true)
       )
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(position))
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(14.0F))
    }



}