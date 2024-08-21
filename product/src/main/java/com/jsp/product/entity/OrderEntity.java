package com.jsp.product.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_info")
public class OrderEntity {
	@Id
	@Column(name = "alt_key")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int altKey;

	@Column(name = "order_id")
	private String orderId;

	@Column(name = "total_price")
	private Double totalPrice;

	@Column(name = "product_id")
	private long productId;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "order_date")
	private Date orderDate;

	@Column(name = "create_date")
	private Date createDate;

	@Column(name = "modified_date", nullable = true)
	private Date modifiedDate;

	public OrderEntity() {
		super();
	}

	public int getAltKey() {
		return altKey;
	}

	public void setAltKey(int altKey) {
		this.altKey = altKey;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
