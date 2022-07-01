package com.exploremore.exceptions;

public class OrderNotFoundException extends Exception {

	int id;

	public OrderNotFoundException(int id) {
		this.id = id;
	}

	@Override
	public String getMessage() {
		return "No Order found with id: " + id + ". Please try again.";
	}

}
