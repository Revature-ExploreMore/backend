package com.exploremore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart_course_details")
public class CartCourseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "course_id")
	private int courseId;

	@Column(name = "cart_id")
	private int cartId;

	public CartCourseEntity() {
	}

	public CartCourseEntity(int id, int courseId, int cartId) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.cartId = cartId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	@Override
	public String toString() {
		return "CartCoursePojo [id=" + id + ", courseId=" + courseId + ", cartId=" + cartId + "]";
	}

}
