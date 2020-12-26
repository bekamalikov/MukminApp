package com.kg.malikov.mukminapp.data.network.quran

import com.kg.malikov.mukminapp.models.quran.QuranModel
import com.kg.malikov.mukminapp.models.quran.SuraModel
import retrofit2.http.GET
import retrofit2.http.Path

interface QuranApi {
    @GET("v1/quran/ru.kuliev")
    suspend fun fethQuran(): QuranModel

    @GET("v1/surah/{surah}/ru.kuliev")
    suspend fun fethQuranSura(@Path("surah") sura: String?): SuraModel
}