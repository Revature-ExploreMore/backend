package com.ExploreMore.pojo;


public class UserPojo {
	
	private int userId;
	private String name;
	private String email;
	private String phoneNumber;
	private String username;
	private String password;
	private int userIdRole;
	
	
	public UserPojo() {
	}

	public UserPojo(int userId, String name, String email, String phoneNumber, String username, String password,
			int userIdRole) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
		this.userIdRole = userIdRole;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public int getUserIdRole() {
		return userIdRole;
	}

	public void setUserIdRole(int userIdRole) {
		this.userIdRole = userIdRole;
	}

	@Override
	public String toString() {
		return "UserPojo [userId=" + userId + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", username=" + username + ", password=" + password + ", userIdRole=" + userIdRole + "]";
	}
	
}
