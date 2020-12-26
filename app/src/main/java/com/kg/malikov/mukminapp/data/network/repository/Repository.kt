package com.kg.malikov.mukminapp.data.network.repository

import android.util.Log
import androidx.lifecycle.liveData
import com.kg.malikov.mukminapp.data.network.Resource
import com.kg.malikov.mukminapp.data.network.namaztime.NamazTimeApi
import com.kg.malikov.mukminapp.data.network.quran.QuranApi
import com.kg.malikov.mukminapp.utils.*
import kotlinx.coroutines.Dispatchers

class Repository(
    val apiNamaz: NamazTimeApi,
    val apiQuran: QuranApi
) {
    fun fetchNamazTimeFromNetworkByCalendar() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            val data = apiNamaz.fetchNamazTime(
                LATITUDE_BISHKEK, LONGITUDE_BISHKEK, METHOD, MONTH, YEAR,
                SCHOOL_HANAFI
            )
            emit(Resource.success(data = data))
            Log.e("ololo", "fetchNamazTimeFromNetwork:  $data")
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error"))
        }

    }

    fun fetchNamazTimeTodayFromNetworkByCity() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            val data = apiNamaz.fetchTodayNamazTimeyCity(
                METHOD, SCHOOL_HANAFI, BISHKEK, KYRGYZSTAN
            )
            emit(Resource.success(data = data))
            Log.e("ololo", "fetchNamazTimeFromNetwork:  $data")
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error"))
        }

    }

    fun fetchQuranFromNetwork() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            val data = apiQuran.fethQuran()
            emit(Resource.success(data = data))
            Log.e("ololo", "fetchQuranFromNetwork:  $data")
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error"))
        }

    }

    fun fetchSuraFromQuranFromNetwork(numberSura: String?) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            val data = apiQuran.fethQuranSura(numberSura)
            emit(Resource.success(data = data))
            Log.e("bn", "fetchSuraFromQuranFromNetwork:  $data")
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error"))
        }

    }


}
