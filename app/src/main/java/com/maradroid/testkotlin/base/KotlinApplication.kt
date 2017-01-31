package com.maradroid.testkotlin.base

import android.app.Application

/**
 * Created by mara on 1/24/17.
 */
class KotlinApplication : Application() {

    companion object {
       lateinit var component : AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().build()
    }
}