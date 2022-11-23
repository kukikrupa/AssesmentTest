package com.almulla.assesmenttest

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**  Top Application class */
@HiltAndroidApp
open class App : Application() {

    companion object {
        lateinit var INSTANCE: App
    }

    var isAnimEnable = false

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}