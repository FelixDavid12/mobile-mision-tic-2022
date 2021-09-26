package com.lospythones.mobilemisiontic2022.model

import java.io.Serializable

data class POI(
    val name: String,
    val location: String,
    val rating: String,
    val img: String,
    val detail: String,
    val gallery: List<String>,
): Serializable