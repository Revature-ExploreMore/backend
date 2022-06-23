package com.exploremore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_course_details")
public class OrderCourseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "order_id")
	private int orderId;

	@Column(name = "course_id")
	private int courseId;

	public OrderCourseEntity() {
	}

	public OrderCourseEntity(int id, int orderId, int courseId) {
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