package com.exploremore.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name = "user_id")
	private int userId;

	public OrderEntity() {
	}

	public OrderEntity(int id, LocalDateTime orderTimestamp, BigDecimal orderTotal, int userId) {
		super();
		this.id = id;
		this.orderTimestamp = orderTimestamp;
		this.orderTotal = orderTotal;
		this.userId = userId;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "OrderPojo [id=" + id + ", orderTimestamp=" + orderTimestamp + ", orderTotal=" + orderTotal + ", userId="
				+ userId + "]";
	}

}

