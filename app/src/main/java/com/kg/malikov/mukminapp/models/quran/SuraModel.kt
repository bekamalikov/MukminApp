package com.kg.malikov.mukminapp.models.quran

data class SuraModel(
    val code: Int? = null,
    val status: String? = null,
    val data: SuraData? = null
)

data class SuraData(
    var number: Int? = null,
    var name: String? = null,
    var englishName: String? = null,
    var englishNameTranslation: String? = null,
    var revelationType: String? = null,
    var ayahs: MutableList<Ayah>? = null,
    var numberOfAyahs: Int? = null,
    var edition: Edition? = null
)
