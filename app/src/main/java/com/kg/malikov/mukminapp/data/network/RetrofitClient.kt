package com.kg.malikov.mukminapp.data.network

import com.kg.malikov.mukminapp.data.network.namaztime.NamazTimeApi
import com.kg.malikov.mukminapp.data.network.quran.QuranApi
import com.kg.malikov.mukminapp.utils.BASE_URL_NAMAZ
import com.kg.malikov.mukminapp.utils.BASE_URL_QURAN
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitClient {

    private val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor)
        .build()

    private val retrofitNamazTime: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL_NAMAZ)
        .client(okHttpClient)
        .build()

    private val retrofitQuran: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL_QURAN)
        .client(okHttpClient)
        .build()

    fun instanceRetrofitNamazTime(): NamazTimeApi {
        return retrofitNamazTime.create(NamazTimeApi::class.java)
    }

    fun instanceRetrofitQuran(): QuranApi {
        return retrofitQuran.create(QuranApi::class.java)
    }


}