package com.exploremore.exceptions;

public class CourseNotFoundException extends Exception {
	int id;
	
	public CourseNotFoundException(int id) {
		this.id = id;
	}
	
	@Override
	public String getMessage() {
		return "Course with ID:" + id +" not Found!";
	}

}
