package me.firdaus1453.koinsample

import android.app.Application
import me.firdaus1453.koinsample.koin.appComponent
import org.koin.android.ext.android.startKoin

/**
 * Created by firdaus1453 on 2/17/2019.
 */
class MainApp : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin(this, appComponent)
    }
}