package com.maradroid.testkotlin.base

import com.maradroid.testkotlin.home.HomeComponent
import com.maradroid.testkotlin.home.HomeModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by mara on 1/24/17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun plus(homeModule: HomeModule): HomeComponent
}