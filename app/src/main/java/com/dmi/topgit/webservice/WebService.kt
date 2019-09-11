package com.dmi.finance.model.webservice

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import java.util.*


interface WebService {
    @GET("developers")
    fun getUserList(
        @Query("language") newsSource: String,
        @Query("since") apiKey: String
    ): Observable<JsonArray>
}