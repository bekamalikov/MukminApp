package com.kg.malikov.mukminapp.di

import com.kg.malikov.mukminapp.data.network.RetrofitClient
import com.kg.malikov.mukminapp.data.network.repository.Repository
import com.kg.malikov.mukminapp.ui.fragments.compass.CompassViewModel
import com.kg.malikov.mukminapp.ui.fragments.detail_ayat.DetailAyatViewModel
import com.kg.malikov.mukminapp.ui.fragments.dua.DuaViewModel
import com.kg.malikov.mukminapp.ui.fragments.hadis.HadisViewModel
import com.kg.malikov.mukminapp.ui.fragments.main.MainViewModel
import com.kg.malikov.mukminapp.ui.fragments.namaz.NamazViewModel
import com.kg.malikov.mukminapp.ui.fragments.name.NameViewModel
import com.kg.malikov.mukminapp.ui.fragments.quran.QuranViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

var viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { DuaViewModel() }
    viewModel { HadisViewModel() }
    viewModel { CompassViewModel() }
    viewModel { NamazViewModel() }
    viewModel { NameViewModel(get()) }
    viewModel { QuranViewModel(get()) }
    viewModel { DetailAyatViewModel(get()) }
}
var networkModule = module {
    single { RetrofitClient() }
    single { RetrofitClient().instanceRetrofitNamazTime() }
    single { RetrofitClient().instanceRetrofitQuran() }
}
var repositoryModule = module {
    factory { Repository(get(), get()) }
}