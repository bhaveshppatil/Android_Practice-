package com.example.postrequest;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseModel implements Serializable {

	@SerializedName("email")
	private String email;

	@SerializedName("password")
	private String password;

	@SerializedName("title")
	private String title;

	@SerializedName("requestType")
	private String requestType;

	@SerializedName("id")
	private int id;

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setRequestType(String requestType){
		this.requestType = requestType;
	}

	public String getRequestType(){
		return requestType;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"ResponseModel{" + 
			"email = '" + email + '\'' + 
			",password = '" + password + '\'' + 
			",title = '" + title + '\'' + 
			",requestType = '" + requestType + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}