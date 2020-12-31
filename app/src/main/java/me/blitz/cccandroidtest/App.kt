package me.blitz.cccandroidtest

import android.app.Application
import mainModule
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(mainModule)
        }

    }

}