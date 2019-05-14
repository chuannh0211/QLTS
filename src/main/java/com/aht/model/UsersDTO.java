package com.aht.model;

public class UsersDTO {
	private long id;
//	private String fullname;
	private String username;
	private String password;
	private String passwordConfirm;
//	private String email;
//	private String phone;

	public UsersDTO() {
		// TODO Auto-generated constructor stub
	}

	public UsersDTO(long id, String username, String password, String passwordConfirm) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

}
