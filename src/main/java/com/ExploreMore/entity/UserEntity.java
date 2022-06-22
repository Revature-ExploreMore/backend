package com.ExploreMore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="username")
	private String username;
	
	@Column(name="hashed_password")
	private String password;
	
	@Column(name="user_role_id")
	private int userRoleId;

	public UserEntity() {

	}

	public UserEntity(int userId, String name, String email, String phoneNumber, String username, String password,
			int userRoleId) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
		this.userRoleId = userRoleId;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", username=" + username + ", password=" + password + ", userRoleId=" + userRoleId + "]";
	}	
}
