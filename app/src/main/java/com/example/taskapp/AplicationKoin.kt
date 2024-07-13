package com.example.taskapp

import android.app.Application
import com.example.taskapp.di.appModule
import com.example.taskapp.di.storageModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AplicationKoin:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@AplicationKoin)
            modules(appModule,
                storageModule)
        }
    }
}