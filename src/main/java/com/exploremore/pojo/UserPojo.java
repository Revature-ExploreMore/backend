package com.exploremore.pojo;

import java.time.LocalDateTime;

public class UserPojo {

	private int id;
	private String name;
	private String email;
	private String phoneNumber;
	private String username;
	private String password;
	private boolean darkModePreference;
	private LocalDateTime registerDate;
	private int roleId;

	public UserPojo() {
	}

	public UserPojo(int id, String name, String email, String phoneNumber, String username, String password,
			boolean darkModePreference, LocalDateTime registerDate, int roleId) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
		this.darkModePreference = darkModePreference;
		this.registerDate = registerDate;
		this.roleId = roleId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean isDarkModePreference() {
		return darkModePreference;
	}

	public void setDarkModePreference(boolean darkModePreference) {
		this.darkModePreference = darkModePreference;
	}

	public LocalDateTime getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDateTime registerDate) {
		this.registerDate = registerDate;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "UserPojo [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", username=" + username + ", password=" + password + ", darkModePreference=" + darkModePreference
				+ ", registerDate=" + registerDate + ", roleId=" + roleId + "]";
	}

}
