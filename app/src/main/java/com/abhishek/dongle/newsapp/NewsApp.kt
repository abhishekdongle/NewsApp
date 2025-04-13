package com.abhishek.dongle.newsapp

import android.app.Application
import com.abhishek.dongle.newsapp.di.sharedKoinModules
import com.abhishek.dongle.newsapp.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NewsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKotlin()
    }

    private fun initKotlin() {
        val modules = sharedKoinModules + viewModelModules
        startKoin {
            androidContext(this@NewsApp)
            modules(modules)
        }
    }
}
