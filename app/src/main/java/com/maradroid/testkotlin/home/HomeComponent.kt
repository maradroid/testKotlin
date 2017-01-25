package com.maradroid.testkotlin.home

import com.maradroid.testkotlin.base.DIScope
import dagger.Subcomponent

/**
 * Created by mara on 1/24/17.
 */
@DIScope
@Subcomponent(modules = arrayOf(HomeModule::class))
interface HomeComponent {
    fun inject(homeActivity: HomeActivity)
}