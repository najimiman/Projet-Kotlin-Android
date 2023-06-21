package com.example.myapplication

import com.google.gson.annotations.SerializedName

data class taskResponse(
    @SerializedName("id") var id:Int?=0,
    @SerializedName("title") var title:String? ="",
    @SerializedName("priority") var priority:Int?=0
)
