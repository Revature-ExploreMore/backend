package com.exploremore.pojo;

public class BillingPojo {

	private String id;
	private String streetName;
	private String city;
	private String state;
	private int zipCode;
	private int userId;

	public BillingPojo() {
	}

	public BillingPojo(String id, String streetName, String city, String state, int zipCode, int userId) {
		super();
		this.id = id;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "BillingPojo [id=" + id + ", streetName=" + streetName + ", city=" + city + ", state=" + state
				+ ", zipCode=" + zipCode + ", userId=" + userId + "]";
	}

}
