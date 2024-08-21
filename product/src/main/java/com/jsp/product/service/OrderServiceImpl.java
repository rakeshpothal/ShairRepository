package com.jsp.product.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.product.DTO.OrderDTO;
import com.jsp.product.entity.InventoryEntity;
import com.jsp.product.entity.OrderEntity;
import com.jsp.product.entity.ProductEntity;
import com.jsp.product.repository.OrderRepository;
import com.jsp.product.util.RandomNumber;

@Component
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ProductServiceImpl productServiceImpl;

	@Autowired
	private RandomNumber randomNumberGenerator;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void processOrder(List<OrderDTO> oredrDtos) {
		String orderId = "ORDER_" + randomNumberGenerator.generateRandomNumber();
		for (OrderDTO orderDTO : oredrDtos) {
			long skuCode = orderDTO.getSkuCode();
			ProductEntity productBySkuCode = productServiceImpl.getProductBySkuCode(skuCode);
			InventoryEntity inventoryBySkuCode = productServiceImpl.getInventoryBySkuCode(skuCode);

			if (orderDTO.getQuantity() <= inventoryBySkuCode.getQuantity()) {
				OrderEntity orderEntity = new OrderEntity();
				orderEntity.setOrderId(orderId);
				orderEntity.setTotalPrice(productBySkuCode.getPrice() * orderDTO.getQuantity());
				orderEntity.setProductId(skuCode);
				orderEntity.setQuantity(orderDTO.getQuantity());
				orderEntity.setOrderDate(new Date());
				orderEntity.setCreateDate(new Date());

				orderRepository.save(orderEntity);
				new Thread() {
					@Override
					public void run() {
						int quantity = inventoryBySkuCode.getQuantity() - orderDTO.getQuantity();
						int updateProductQuantity = productServiceImpl.updateProductQuantity(skuCode, quantity);
						System.out.println(updateProductQuantity);
					}
				}.start();
			}

		}

	}

}
