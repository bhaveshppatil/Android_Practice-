package com.example.getuserdetails_kotlin

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResponseModel(

	@field:SerializedName("data")
	val data: DataModel? = null,

	@field:SerializedName("support")
	val support: SupportModel? = null
)