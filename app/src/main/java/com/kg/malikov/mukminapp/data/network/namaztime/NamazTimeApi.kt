package com.kg.malikov.mukminapp.data.network.namaztime

import com.kg.malikov.mukminapp.models.namaztime.NamazTimeModel
import com.kg.malikov.mukminapp.models.namaztime.NamazTimeModelToday
import retrofit2.http.GET
import retrofit2.http.Query

interface NamazTimeApi {
    @GET("v1/calendar")
    suspend fun fetchNamazTime(
        @Query("latitude") latitude: String,
        @Query("longitude") longitude: String,
        @Query("method") method: String,
        @Query("month") month: String,
        @Query("year") year: String,
        @Query("school") school: String
    ): NamazTimeModel

    @GET("v1/timingsByCity")
    suspend fun fetchTodayNamazTimeyCity(
        @Query("method") method: String,
        @Query("school") school: String,
        @Query("city") city: String,
        @Query("country") country: String,
    ): NamazTimeModelToday


}