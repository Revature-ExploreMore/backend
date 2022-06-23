package com.exploremore.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "username")
	private String username;

	@Column(name = "hashed_password")
	private String password;

	@Column(name = "dark_mode_preference")
	private boolean darkModePreference;

	@Column(name = "register_date")
	private LocalDateTime registerDate;

	@Column(name = "role_id")
	private int roleId;

	public UserEntity() {
	}

	public UserEntity(int id, String name, String email, String phoneNumber, String username, String password,
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
