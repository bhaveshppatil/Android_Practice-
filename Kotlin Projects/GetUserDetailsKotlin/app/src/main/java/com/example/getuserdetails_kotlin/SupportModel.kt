package com.example.getuserdetails_kotlin

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SupportModel(

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("text")
	val text: String? = null
)