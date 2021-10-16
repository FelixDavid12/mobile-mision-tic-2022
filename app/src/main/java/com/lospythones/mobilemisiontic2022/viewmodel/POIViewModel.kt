package com.lospythones.mobilemisiontic2022.viewmodel

import androidx.lifecycle.*
import com.lospythones.mobilemisiontic2022.data.remote.RetrofitFactory
import com.lospythones.mobilemisiontic2022.model.POIModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class POIViewModel : ViewModel() {

    private var apiService = RetrofitFactory.apiService()

    private var pois = MutableLiveData<List<POIModel>>()
    var poisLiveData: LiveData<List<POIModel>> = pois

    init {
        getPois()
    }

    fun getPois() {
        // Coroutine that will be canceled when the ViewModel is cleared.
        viewModelScope.launch {
            pois.value = requestPois()
        }
    }

    suspend fun requestPois(): List<POIModel> {
        return withContext(Dispatchers.IO) {
            apiService.requestPois()
        }
    }
}
