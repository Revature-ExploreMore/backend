package com.exploremore.exceptions;

public class EmptyCartException extends Exception {
	
	@Override
	public String getMessage() {
		return "Cart is Empty!!";
	}

}
