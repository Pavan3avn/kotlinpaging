package com.pavan.kotlinpaging.retrofit

import com.pavan.kotlinpaging.models.Quotelist
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface QuoteApi {

    @GET("/quotes")
    suspend fun getallresults(@Query("page") Page :Int ):Quotelist

}