package com.exploremore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_course_details")
public class CartCourseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private CourseEntity course;

	@ManyToOne()
	@JoinColumn(name="id", nullable=false,insertable=false, updatable=false)
	private CartEntity cart;

	public CartCourseEntity() {
	}

	public CartCourseEntity(int id, CourseEntity course, CartEntity cart) {
		super();
		this.id = id;
		this.course = course;
		this.cart = cart;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CourseEntity getCourse() {
		return course;
	}

	public void setCourse(CourseEntity course) {
		this.course = course;
	}

	public CartEntity getCart() {
		return cart;
	}

	public void setCart(CartEntity cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "CartCourseEntity [id=" + id + ", course=" + course + ", cart=" + cart + "]";
	}

	

}
