package com.maradroid.testkotlin.home.presenter

import com.maradroid.testkotlin.home.HomeView
import com.maradroid.testkotlin.model.data_model.Response
import com.maradroid.testkotlin.model.interactors.HomeInteractor
import com.maradroid.testkotlin.model.interactors.listener.HomeListener
import javax.inject.Inject

/**
 * Created by mara on 1/24/17.
 */
class HomePresenterImpl @Inject constructor(val homeView: HomeView, val homeInteractor: HomeInteractor) : HomePresenter, HomeListener{

    companion object {
        val limit = "20"
    }

    override fun onStart() {
        homeInteractor.getData(limit, this)
    }

    override fun onStop() {
        homeInteractor.unsubscribe()
    }

    override fun onDataError(message: String) {
        homeView.showErrorMessage(message)
    }

    override fun onDataSuccess(response: Response) {
        homeView.setupRecyclerData(response.data)
    }
}