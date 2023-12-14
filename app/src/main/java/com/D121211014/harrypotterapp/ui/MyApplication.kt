package com.D121211014.harrypotterapp.ui

import android.app.Application
import com.D121211014.harrypotterapp.data.AppContainer
import com.D121211014.harrypotterapp.data.DefaultAppContainer

class MyApplication: Application(){
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}