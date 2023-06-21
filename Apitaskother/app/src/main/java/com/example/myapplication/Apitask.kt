package com.example.myapplication

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Apitask {
    @GET("/api/tasks/find_by_id/{id}")
    suspend fun gettaskbyID(@Path("id") id:String):Response<BaseReasponse<taskResponse>>

}