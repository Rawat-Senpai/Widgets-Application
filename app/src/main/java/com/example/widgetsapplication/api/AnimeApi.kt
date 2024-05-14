package com.example.widgetsapplication.api

import com.example.widgetsapplication.models.AkatsukiMember
import com.example.widgetsapplication.models.AkatsukiResponse
import retrofit2.Response
import retrofit2.http.GET

interface AnimeApi {

//    @GET("character")
    @GET("akatsuki")
    suspend fun  getAllAkatsukiMembers():Response<AkatsukiResponse>
}