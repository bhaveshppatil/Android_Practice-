package com.example.kotlinscopingfunctionsiw

import com.google.gson.annotations.SerializedName

data class ResponseModel(

	@field:SerializedName("data")
	val data: DataModel? = null,

	@field:SerializedName("support")
	val support: SupportModel? = null
)