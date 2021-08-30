package com.example.postrequest_kotlin

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResponseModel(

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("requestType")
	val requestType: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)