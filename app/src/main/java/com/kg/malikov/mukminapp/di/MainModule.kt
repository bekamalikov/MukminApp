package com.kg.malikov.mukminapp.di

import com.kg.malikov.mukminapp.ui.fragments.compass.CompassViewModel
import com.kg.malikov.mukminapp.ui.fragments.dua.DuaViewModel
import com.kg.malikov.mukminapp.ui.fragments.hadis.HadisViewModel
import com.kg.malikov.mukminapp.ui.fragments.main.MainViewModel
import com.kg.malikov.mukminapp.ui.fragments.namaz.NamazViewModel
import com.kg.malikov.mukminapp.ui.fragments.name.NameViewModel
import com.kg.malikov.mukminapp.ui.fragments.quran.QuranViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

var viewModelModule = module {
viewModel { MainViewModel()}
viewModel { DuaViewModel()}
viewModel { HadisViewModel()}
viewModel { CompassViewModel()}
viewModel { NamazViewModel()}
viewModel { NameViewModel()}
viewModel { QuranViewModel()}
}