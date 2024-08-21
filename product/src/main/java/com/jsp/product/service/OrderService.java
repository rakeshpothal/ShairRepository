package com.jsp.product.service;

import java.util.List;

import com.jsp.product.DTO.OrderDTO;

public interface OrderService {
	public void processOrder(List<OrderDTO> oredrDtos);
}
