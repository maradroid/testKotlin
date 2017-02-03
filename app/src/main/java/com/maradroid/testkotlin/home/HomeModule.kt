package com.maradroid.testkotlin.home

import com.maradroid.testkotlin.base.DIScope
import com.maradroid.testkotlin.home.adapter.RecyclerAdapter
import com.maradroid.testkotlin.home.presenter.HomePresenter
import com.maradroid.testkotlin.home.presenter.HomePresenterImpl
import com.maradroid.testkotlin.model.interactors.HomeInteractor
import com.maradroid.testkotlin.model.interactors.HomeInteractorImpl
import dagger.Module
import dagger.Provides

/**
 * Created by mara on 1/24/17.
 */
@Module
class HomeModule(val view: HomeView) {

    @DIScope
    @Provides
    fun provideView(): HomeView = view

    @DIScope
    @Provides
    fun provideHomePresenter(homePresenterImpl: HomePresenterImpl): HomePresenter = homePresenterImpl


    @DIScope
    @Provides
    fun provideHomeInteractor(homeInteractorImpl: HomeInteractorImpl): HomeInteractor = homeInteractorImpl

    @DIScope
    @Provides
    fun provideRecyclerAdapter() = RecyclerAdapter()
}