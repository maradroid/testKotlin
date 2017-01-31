package com.maradroid.testkotlin.model.data_model

import com.squareup.moshi.Json
import java.util.*

/**
 * Created by mara on 1/29/17.
 */
class Response {

    @Json(name="children")
    var data: List<Data>? = null
        get() = data ?: ArrayList<Data>()

    constructor(data: List<Data>) {
        this.data = data
    }

    constructor()
}