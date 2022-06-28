package com.exploremore.pojo;

public class CoursePojo {

	private int id;
	private String name;
	private String description;
	private double price;
	private String imageUrl;
	private CategoryPojo category;

	public CoursePojo() {
	}
	public CoursePojo(int id, String name, String description, double price, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imageUrl = imageUrl;
	
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

	public CategoryPojo getCategory() {
		return category;
	}

	public void setCategoryId(CategoryPojo category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "CoursePojo [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", imageUrl=" + imageUrl + ", category=" + category + "]";
	}

}
