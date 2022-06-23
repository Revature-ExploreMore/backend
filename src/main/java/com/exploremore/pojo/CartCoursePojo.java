package com.exploremore.pojo;

public class CartCoursePojo {

	private int id;
	private int courseId;
	private int cartId;

	public CartCoursePojo() {
	}

	public CartCoursePojo(int id, int courseId, int cartId) {
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
