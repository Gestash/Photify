package com.gestash.photify

import android.app.Application
import com.gestash.photify.di.Di
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class PhotiFyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@PhotiFyApplication)
            modules(Di.koinModules)
        }
    }
}