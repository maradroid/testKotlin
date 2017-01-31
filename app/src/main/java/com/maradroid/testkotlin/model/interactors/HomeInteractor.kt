package com.maradroid.testkotlin.model.interactors

import com.maradroid.testkotlin.model.interactors.listener.HomeListener

/**
 * Created by mara on 1/24/17.
 */
interface HomeInteractor {
    fun getData(limit: String, listener: HomeListener)
    fun unsubscribe()
}