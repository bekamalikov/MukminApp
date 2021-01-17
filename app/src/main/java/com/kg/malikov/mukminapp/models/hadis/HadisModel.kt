package com.kg.malikov.mukminapp.models.hadis

import java.io.Serializable

data class HadisModel(
    val id: String = "",
    val arabDescription: String = "",
    val description: String = "",
    val nameHadis: String = "",
    val numberHadis: Int? = null,
    val title: String = "",
):Serializable
