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
@Table(name = "cart_entity")
public class CartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "modified_at")
	private LocalDateTime modifiedAt;
	
	@Column(name="is_removed")
	private boolean isRemoved;
	
	@Column(name="cart_total")
	private BigDecimal cartTotal;

	@Column(name = "user_id")
	private int userId;
	
	@Column(name="order_id")
	private int orderId;

	public CartEntity() {
	}

	public CartEntity(int id, LocalDateTime createdAt, LocalDateTime modifiedAt, boolean isRemoved, BigDecimal cartTotal,
			int userId, int orderId) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.isRemoved = isRemoved;
		this.cartTotal = cartTotal;
		this.userId = userId;
		this.orderId = orderId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public boolean isRemoved() {
		return isRemoved;
	}

	public void setRemoved(boolean isRemoved) {
		this.isRemoved = isRemoved;
	}

	public BigDecimal getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(BigDecimal cartTotal) {
		this.cartTotal = cartTotal;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "CartPojo [id=" + id + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + ", isRemoved="
				+ isRemoved + ", cartTotal=" + cartTotal + ", userId=" + userId + ", orderId=" + orderId + "]";
	}

}
