package com.devpadawan.footballresults.service

import com.devpadawan.footballresults.model.Competition
import retrofit2.Call
import retrofit2.http.GET

interface ApiFootball {

    @GET("v2/competitions")
    fun getAllCompetitors():Call<Competition>
}