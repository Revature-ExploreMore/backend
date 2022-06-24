package com.exploremore.pojo;

public class CartCoursePojo {

	private int id;
	private CartPojo cart;
	private CoursePojo course;

	public CartCoursePojo() {
	}

	public CartCoursePojo(int id, CoursePojo course, CartPojo cart) {
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

	public CartPojo getCart() {
		return cart;
	}

	public void setCart(CartPojo cart) {
		this.cart = cart;
	}

	public CoursePojo getCourse() {
		return course;
	}

	public void setCourse(CoursePojo course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "CartCoursePojo [id=" + id + ", cart=" + cart + ", course=" + course + "]";
	}

	

}
