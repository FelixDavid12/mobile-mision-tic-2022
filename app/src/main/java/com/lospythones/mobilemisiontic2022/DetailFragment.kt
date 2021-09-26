package com.lospythones.mobilemisiontic2022

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import com.lospythones.mobilemisiontic2022.databinding.FragmentDetailBinding
import com.lospythones.mobilemisiontic2022.model.POI

class DetailFragment : Fragment() {
    companion object {
        const val POI_SELECTED = "poi"
    }

    private var poiInfo: POI? = null

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            poiInfo = it.getSerializable(POI_SELECTED) as POI?
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

        binding.poiImgMap.setImageDrawable((getImage(0)))
        binding.mainImageView.setImageDrawable(getImage(1))
        binding.imageButton3.setImageDrawable(getImage(1))
        binding.imageButton4.setImageDrawable(getImage(2))
        binding.imageButton5.setImageDrawable(getImage(3))
        binding.imageButton6.setImageDrawable(getImage((4)))
        (requireActivity() as MainActivity).title = binding.poiName.text
    }

    override fun onDestroy() {
        super.onDestroy()
        (requireActivity() as MainActivity).title = "Paris"
        _binding = null
    }

    private fun getImage(index: Int): Drawable? {
        val context = requireContext()

        val uri = "@drawable/${poiInfo?.gallery?.get(index)}"
        val imageResource = context.resources.getIdentifier(uri, null, context.packageName)

        return AppCompatResources.getDrawable(context, imageResource)
    }
}