package com.example.kotlinscopingfunctionsyou

import com.google.gson.annotations.SerializedName

data class SupportModel(

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("text")
    val text: String? = null
)