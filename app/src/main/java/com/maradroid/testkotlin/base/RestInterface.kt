package com.maradroid.testkotlin.base

import com.maradroid.testkotlin.model.data_model.Response
import com.serjltt.moshi.adapters.Wrapped
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by mara on 1/29/17.
 */
interface RestInterface {

    @GET("/top.json")
    @Wrapped("data")
    fun getData(@Query("limit") limit: String): Observable<Response>
}