package com.example.myapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Url {
    private  const val baseurl="http://127.0.0.1:8000"
    fun gettask():Retrofit{
        return Retrofit.Builder().baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
