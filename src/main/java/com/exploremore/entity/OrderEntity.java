package com.exploremore.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "order_timestamp")
	private LocalDateTime orderTimestamp;
	
	@Column(name="order_total")
	private BigDecimal orderTotal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	Set<OrderCourseEntity> orderCourses = new HashSet<OrderCourseEntity>();

	public OrderEntity() {
	}

	public OrderEntity(int id, LocalDateTime orderTimestamp, BigDecimal orderTotal, UserEntity user) {
		super();
		this.id = id;
		this.orderTimestamp = orderTimestamp;
		this.orderTotal = orderTotal;
		this.user = user;
	}
	public OrderEntity(int id, LocalDateTime orderTimestamp, BigDecimal orderTotal, UserEntity user, 
			Set<OrderCourseEntity> orderCourses) {
		super();
		this.id = id;
		this.orderTimestamp = orderTimestamp;
		this.orderTotal = orderTotal;
		this.user = user;
		this.orderCourses = orderCourses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getOrderTimestamp() {
		return orderTimestamp;
	}

	public void setOrderTimestamp(LocalDateTime orderTimestamp) {
		this.orderTimestamp = orderTimestamp;
	}

	public BigDecimal getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	

	public Set<OrderCourseEntity> getOrderCourses() {
		return orderCourses;
	}

	public void setOrderCourses(Set<OrderCourseEntity> orderCourses) {
		this.orderCourses = orderCourses;
	}

	@Override
	public String toString() {
		return "OrderPojo [id=" + id + ", orderTimestamp=" + orderTimestamp + ", orderTotal=" + orderTotal + ", userId="
				+ user + "]";
	}

}

