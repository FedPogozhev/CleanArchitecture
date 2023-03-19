package com.example.callforinternet.app

import android.app.Application
import com.example.callforinternet.presentation.di.AppComponent
import com.example.callforinternet.presentation.di.AppModule
import com.example.callforinternet.presentation.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(
            AppModule(context = this)
        ).build()
    }
}