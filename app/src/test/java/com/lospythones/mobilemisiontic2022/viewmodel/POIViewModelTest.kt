package com.lospythones.mobilemisiontic2022.viewmodel

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Test

class POIViewModelTest {

    @Test
    fun requestPois_isNotNull() = runBlocking {
        val viewModel = POIViewModel()

        assertNotNull(viewModel.requestPois())
    }
}