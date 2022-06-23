package com.exploremore.pojo;

public class PaymentPojo {

	private int id;
	private String cardType;
	private String cardNumber;
	private String expDate;
	private int cvv;
	private int userId;

	public PaymentPojo() {
	}

	public PaymentPojo(int id, String cardType, String cardNumber, String expDate, int cvv, int userId) {
		super();
		this.id = id;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.expDate = expDate;
		this.cvv = cvv;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "PaymentPojo [id=" + id + ", cardType=" + cardType + ", cardNumber=" + cardNumber + ", expDate="
				+ expDate + ", cvv=" + cvv + ", userId=" + userId + "]";
	}

}
