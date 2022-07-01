package com.exploremore.exceptions;

public class EmptyCartList extends Exception{

	@Override
	public String getMessage() {
		return "Empty Order List";
	}

}
