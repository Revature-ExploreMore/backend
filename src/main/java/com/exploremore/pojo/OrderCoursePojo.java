package com.exploremore.pojo;

public class OrderCoursePojo {

	private int id;
	private int orderId;
	private int courseId;

	public OrderCoursePojo() {
	}

	public OrderCoursePojo(int id, int orderId, int courseId) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.courseId = courseId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "OrderCoursePojo [id=" + id + ", orderId=" + orderId + ", courseId=" + courseId + "]";
	}

}
