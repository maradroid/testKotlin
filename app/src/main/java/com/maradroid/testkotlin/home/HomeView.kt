package com.maradroid.testkotlin.home

import com.maradroid.testkotlin.model.data_model.Data

/**
 * Created by mara on 1/24/17.
 */
interface HomeView {
    fun setupRecyclerData(data: List<Data>?)
    fun showErrorMessage(message: String)
}