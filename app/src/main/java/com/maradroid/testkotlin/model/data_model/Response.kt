package com.maradroid.testkotlin.model.data_model

import com.squareup.moshi.Json
import java.util.*

/**
 * Created by mara on 1/29/17.
 */
data class Response(@Json(name="children") var data: List<Data>?) {
}