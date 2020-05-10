package com.example.demo.dto;

public class UserDTO {

	private String name;
	private String apartment;
	private String login;
	private String password;

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public String getApartment () {
		return apartment;
	}

	public void setApartment (String apartment) {
		this.apartment = apartment;
	}

	public String getLogin () {
		return login;
	}

	public void setLogin (String login) {
		this.login = login;
	}

	public String getPassword () {
		return password;
	}

	public void setPassword (String password) {
		this.password = password;
	}
}
