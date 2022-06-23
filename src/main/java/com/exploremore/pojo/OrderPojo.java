package com.exploremore.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderPojo {

	private int id;
	private LocalDateTime orderTimestamp;
	private BigDecimal orderTotal;
	private int userId;

	public OrderPojo() {
	}

	public OrderPojo(int id, LocalDateTime orderTimestamp, BigDecimal orderTotal, int userId) {
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
