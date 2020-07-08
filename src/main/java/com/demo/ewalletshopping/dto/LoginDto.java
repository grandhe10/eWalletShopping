package com.demo.ewalletshopping.dto;

import javax.validation.constraints.NotEmpty;

public class LoginDto {
	
	@NotEmpty(message="userName is mandatory field")
	private String userName;
	@NotEmpty(message="password is mandatory field")
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
