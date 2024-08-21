package com.jsp.product.service;

import java.util.List;

import com.jsp.product.DTO.ProductDTO;
import com.jsp.product.entity.InventoryEntity;
import com.jsp.product.entity.ProductEntity;

public interface ProductService {
	public void addProduct(ProductDTO productdto);

	public ProductEntity getProductBySkuCode(long skuCode);

	public InventoryEntity getInventoryBySkuCode(long skuCode);

	public int updateProductQuantity(long SkuCode, int quantity);

	public List<ProductDTO> listAllProduct();

}
