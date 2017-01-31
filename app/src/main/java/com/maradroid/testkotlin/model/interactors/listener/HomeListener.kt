package com.maradroid.testkotlin.model.interactors.listener

import com.maradroid.testkotlin.model.data_model.Response

/**
 * Created by mara on 1/24/17.
 */
interface HomeListener {
    fun onDataSuccess(response: Response)
    fun onDataError(message: String)
}