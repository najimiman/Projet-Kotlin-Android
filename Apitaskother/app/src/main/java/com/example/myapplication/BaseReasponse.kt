package com.example.myapplication

import com.google.gson.annotations.SerializedName

data class BaseReasponse<T> (
    @SerializedName("data") var data:T?=null
)