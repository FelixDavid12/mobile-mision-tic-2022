package com.lospythones.mobilemisiontic2022

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.lospythones.mobilemisiontic2022.adapter.ItemAdapter
import com.lospythones.mobilemisiontic2022.data.Datasource
import com.lospythones.mobilemisiontic2022.data.Util
import com.lospythones.mobilemisiontic2022.databinding.FragmentListBinding
import com.lospythones.mobilemisiontic2022.viewmodel.POIViewModel

class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    private lateinit var viewModel: POIViewModel

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
        recyclerView = binding.recyclerView
        recyclerView.adapter = ItemAdapter(context)

        binding.fabSettings.setOnClickListener{ onClick() }

        viewModel = ViewModelProvider(this).get(POIViewModel::class.java)

        viewModel.poisLiveData.observe(viewLifecycleOwner, {
            (recyclerView.adapter as ItemAdapter).updatePoisList(it)
        })


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