package com.almulla.assesmenttest

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.almulla.assesmenttest.ui.component.main.to_do.Task
import dagger.hilt.android.HiltAndroidApp

/**  Top Application class */
@HiltAndroidApp
open class App : Application() {
    var taskList = MutableLiveData<ArrayList<Task>>()

    companion object {
        lateinit var INSTANCE: App
    }

    var isAnimEnable = false

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}