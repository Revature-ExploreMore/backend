package com.exploremore.pojo;

public class OrderCoursePojo {

	private int id;
	private OrderPojo order;
	private CoursePojo course;

	public OrderCoursePojo() {
	}

	public OrderCoursePojo(int id, OrderPojo order, CoursePojo course) {
		super();
		this.id = id;
		this.order = order;
		this.course = course;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OrderPojo getOrder() {
		return order;
	}

	public void setOrder(OrderPojo order) {
		this.order = order;
	}

	public CoursePojo getCourse() {
		return course;
	}

	public void setCourse(CoursePojo course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "OrderCoursePojo [id=" + id + ", order=" + order + ", course=" + course + "]";
	}

}
