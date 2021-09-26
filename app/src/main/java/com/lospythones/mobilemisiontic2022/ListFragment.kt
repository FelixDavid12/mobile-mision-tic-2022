package com.lospythones.mobilemisiontic2022

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.lospythones.mobilemisiontic2022.adapter.ItemAdapter
import com.lospythones.mobilemisiontic2022.data.Datasource
import com.lospythones.mobilemisiontic2022.data.Util
import com.lospythones.mobilemisiontic2022.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater, container, false)

        (requireActivity() as MainActivity).title = "The best app ever -> Paris"

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val context = requireContext()
        val jsonString = Util().getJsonDataFromAsset(context, "mock_poi.json")
        val poiDataset = Datasource().loadPOIs(jsonString)

        recyclerView = binding.recyclerView
        recyclerView.adapter = ItemAdapter(context, poiDataset)

        binding.fabSettings.setOnClickListener{ onClick() }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onClick(){
        val action = ListFragmentDirections.actionListFragmentToSettingsFragment()
        this.findNavController().navigate(action)
    }
}