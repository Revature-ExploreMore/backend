package com.exploremore.pojo;

public class CategoryPojo {

	private int id;
	private String categoryName;


	public CategoryPojo() {
	}

	public CategoryPojo(int id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "CategoryPojo [id=" + id + ", categoryName=" + categoryName + "]";
	}

	

}
