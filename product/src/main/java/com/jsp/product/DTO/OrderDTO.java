package com.jsp.product.DTO;

public class OrderDTO {
	private long skuCode;
	private int quantity;
	public OrderDTO(long skuCode, int quantity) {
		super();
		this.skuCode = skuCode;
		this.quantity = quantity;
	}
	public long getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(long skuCode) {
		this.skuCode = skuCode;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderDTO [skuCode=" + skuCode + ", quantity=" + quantity + "]";
	}

	

}
