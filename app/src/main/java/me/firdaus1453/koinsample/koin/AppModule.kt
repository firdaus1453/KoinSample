package me.firdaus1453.koinsample.koin

import com.google.gson.Gson
import me.firdaus1453.koinsample.presentation.activity.MainPresenter
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

/**
 * Created by firdaus1453 on 2/17/2019.
 */

// TODO 3 Membuat appModule
val appModule = module {
    single{ Gson() }
    factory { MainPresenter(androidContext(),get()) }
}