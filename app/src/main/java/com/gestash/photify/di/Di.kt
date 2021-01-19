package com.gestash.photify.di

import com.gestash.photify.ui.dashboard.DashboardViewModel
import com.gestash.photify.ui.home.HomeViewModel
import com.gestash.photify.utils.FileNameGenerator
import com.gestash.photify.utils.GallerySaver
import com.gestash.photify.utils.MarginDecoration
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Di {

    private val viewModelModule = module {
        viewModel { DashboardViewModel( androidContext(), get()) }
        viewModel { HomeViewModel( get()) }

    }

    private val utilsModule = module {
        single { FileNameGenerator(androidContext().cacheDir) }
        single { GallerySaver(androidContext()) }
        single { MarginDecoration(androidContext()) }
    }

    val koinModules = arrayListOf(viewModelModule, utilsModule)

}