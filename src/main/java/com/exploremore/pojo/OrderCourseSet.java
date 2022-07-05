package com.exploremore.pojo;

import java.util.List;

public class OrderCourseSet {
	
	private OrderPojo order;
	private List<CoursePojo> courses;
	public OrderCourseSet(OrderPojo order, List<CoursePojo> courses) {
		super();
		this.order = order;
		this.courses = courses;
	}
	public OrderPojo getOrder() {
		return order;
	}
	public void setOrder(OrderPojo order) {
		this.order = order;
	}
	public List<CoursePojo> getCourses() {
		return courses;
	}
	public void setCourses(List<CoursePojo> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "OrderCourseSet [order=" + order + ", courses=" + courses + "]";
	}
}
