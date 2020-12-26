package com.kg.malikov.mukminapp.models.quran


data class Ayah(
    var number: Int? = null,
    var text: String? = null,
    var numberInSurah: Int? = null,
    var juz: Int? = null,
    var manzil: Int? = null,
    var page: Int? = null,
    var ruku: Int? = null,
    var hizbQuarter: Int? = null,
 //   var sajda: Boolean? = null
)

data class Data(
    var surahs: MutableList<Surah>?=null,
    var edition: Edition? = null,


)

data class QuranModel(
    var code: Int? = null,
    var status: String? = null,
    var data: Data? = null
)



data class Surah(
    var number: Int? = null,
    var name: String? = null,
    var englishName: String? = null,
    var englishNameTranslation: String? = null,
    var revelationType: String? = null,
    var ayahs: MutableList<Ayah>? = null
)

data class Edition(
    var identifier: String? = null,
    var language: String? = null,
    var name: String? = null,
    var englishName: String? = null,
    var format: String? = null,
    var type: String? = null
)