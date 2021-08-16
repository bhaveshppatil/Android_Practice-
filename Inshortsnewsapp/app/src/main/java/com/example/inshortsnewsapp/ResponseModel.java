package com.example.inshortsnewsapp;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseModel implements Serializable {

	@SerializedName("category")
	private String category;

	@SerializedName("data")
	private List<DataModel> data;

	@SerializedName("success")
	private boolean success;

	public String getCategory(){
		return category;
	}

	public List<DataModel> getData(){
		return data;
	}

	public boolean isSuccess(){
		return success;
	}

	@Override
 	public String toString(){
		return 
			"ResponseModel{" + 
			"category = '" + category + '\'' + 
			",data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			"}";
		}
}