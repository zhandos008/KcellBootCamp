package kz.kcell.kcellbootcamp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber.DebugTree
import timber.log.Timber.Forest.plant

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        plant(DebugTree())
    }
}