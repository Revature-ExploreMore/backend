package com.exploremore.pojo;

import java.math.BigDecimal;

public class CoursePojo {

	private int id;
	private String name;
	private String description;
	private BigDecimal price;
	private String imageUrl;
	private CategoryPojo categoryId;

	public CoursePojo() {
	}

	public CoursePojo(int id, String name, String description, BigDecimal price, String imageUrl, CategoryPojo categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imageUrl = imageUrl;
		this.categoryId = categoryId;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public CategoryPojo getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(CategoryPojo categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "CoursePojo [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", imageUrl=" + imageUrl + ", categoryId=" + categoryId + "]";
	}

}
