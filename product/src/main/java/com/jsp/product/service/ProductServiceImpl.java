package com.jsp.product.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jsp.product.DTO.ProductDTO;
import com.jsp.product.entity.InventoryEntity;
import com.jsp.product.entity.ProductEntity;
import com.jsp.product.repository.InventoryRepository;
import com.jsp.product.repository.ProductRepository;
import com.jsp.product.util.RandomNumber;

@Scope("singleton")
@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	private InventoryRepository inventoryConfig;

	@Autowired
	private ProductRepository productConfig;

	@Autowired
	private RandomNumber randomNumberGenerator;

	@Override
	public void addProduct(ProductDTO productdto) {
		ProductEntity productEntity = new ProductEntity();
		String randomNumber = randomNumberGenerator.generateRandomNumber();

		productEntity.setName(productdto.getName());
		productEntity.setDescription(productdto.getDescription());
		productEntity.setPrice(productdto.getPrice());
		productEntity.setCreatedDate(new Date());
		productEntity.setSkuCode(randomNumber);

		InventoryEntity inventoryEntity = new InventoryEntity();
		inventoryEntity.setSkuCode(randomNumber);
		inventoryEntity.setQuantity(productdto.getQuantity());
		inventoryEntity.setCreatedDate(new Date());

		inventoryConfig.save(inventoryEntity);
		productConfig.save(productEntity);
	}

	@Override
	public ProductEntity getProductBySkuCode(long skuCode) {
		return productConfig.getProductBySkuCode(skuCode);
	}

	@Override
	public InventoryEntity getInventoryBySkuCode(long skuCode) {
		return inventoryConfig.getInventoryBySkuCode(skuCode);
	}

	@Override
	public int updateProductQuantity(long SkuCode, int quantity) {
		return inventoryConfig.updateProductQuantity(SkuCode, quantity);
	}

	@Override
	public List<ProductDTO> listAllProduct() {
		List<ProductDTO> productList = new ArrayList<ProductDTO>();

		List<ProductEntity> allProduct = productConfig.getAllProduct();

		for (ProductEntity productEntity : allProduct) {
			ProductDTO productDTO = new ProductDTO(productEntity.getName(), productEntity.getSkuCode());
			productList.add(productDTO);
		}
		return productList;
	}

}
