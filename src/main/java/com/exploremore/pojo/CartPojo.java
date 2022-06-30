package com.exploremore.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class CartPojo {

	private int id;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	private boolean isRemoved;
	private BigDecimal cartTotal;
	private int userId;
	private int orderId;

	public CartPojo() {
	}

	public CartPojo(int id, LocalDateTime createdAt, LocalDateTime modifiedAt, boolean isRemoved, BigDecimal cartTotal,
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

	@Override
	public int hashCode() {
		return Objects.hash(cartTotal, createdAt, id, isRemoved, modifiedAt, orderId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartPojo other = (CartPojo) obj;
		return Objects.equals(cartTotal, other.cartTotal) && Objects.equals(createdAt, other.createdAt)
				&& id == other.id && isRemoved == other.isRemoved && Objects.equals(modifiedAt, other.modifiedAt)
				&& orderId == other.orderId && userId == other.userId;
	}
	
	

}
