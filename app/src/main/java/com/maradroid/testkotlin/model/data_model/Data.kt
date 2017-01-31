package com.maradroid.testkotlin.model.data_model

import com.squareup.moshi.Json

/**
 * Created by mara on 1/25/17.
 */
data class Data(@Json(name = "data") var item: Item, var kind: String) {
}