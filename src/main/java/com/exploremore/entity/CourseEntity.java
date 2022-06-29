package com.exploremore.entity;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "course")
public class CourseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private double price;
	
	@Column(name="image_url")
	private String imageUrl;
	

	@ManyToOne
	@JoinColumn(name="category_id")
	private CategoryEntity category;
	@OneToMany(mappedBy="course")
	private Set<CartCourseEntity> cartCourses;


	public CourseEntity() {
	}

	public CourseEntity(int id, String name, String description, double price, String imageUrl, CategoryEntity categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imageUrl = imageUrl;
		this.category = categoryId;
	}

	public CourseEntity(int id, String name, String description, double price, String imageUrl, CategoryEntity categoryId,
			Set<CartCourseEntity> cartCourses) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imageUrl = imageUrl;
		this.category = categoryId;
		this.cartCourses = cartCourses;
	}
	
	

	public Set<CartCourseEntity> getCartCourses() {
		return cartCourses;
	}

	public void setCartCourses(Set<CartCourseEntity> cartCourses) {
		this.cartCourses = cartCourses;
	}

	public CourseEntity(int id, String name, String description, double price, String imageUrl, CategoryEntity categoryId,
			Set<CartCourseEntity> cartCourses) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imageUrl = imageUrl;
		this.category = categoryId;
		this.cartCourses = cartCourses;
	}
	
	

	public Set<CartCourseEntity> getCartCourses() {
		return cartCourses;
	}

	public void setCartCourses(Set<CartCourseEntity> cartCourses) {
		this.cartCourses = cartCourses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity categoryId) {
		this.category = categoryId;
	}

	@Override
	public String toString() {
		return "CourseEntity [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", imageUrl=" + imageUrl + ", categoryId=" + category + ", cartCourses=" + cartCourses + "]";
	}

	
}