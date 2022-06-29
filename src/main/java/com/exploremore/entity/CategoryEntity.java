package com.exploremore.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "category")
public class CategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "category_name")
	private String categoryName;

	@OneToMany(mappedBy="category")
	private Set<CourseEntity> courses;

	public CategoryEntity() {
	}

	public CategoryEntity(int id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		
	}
	

	public CategoryEntity(int id, String categoryName, Set<CourseEntity> courses) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.courses = courses;
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
