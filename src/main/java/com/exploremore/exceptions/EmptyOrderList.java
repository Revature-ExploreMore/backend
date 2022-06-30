package com.exploremore.exceptions;

public class EmptyOrderList extends Exception {
	
	@Override
	public String getMessage() {
		return "Empty Order List";
	}

}
