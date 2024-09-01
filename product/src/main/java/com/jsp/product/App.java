package com.jsp.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jsp.product.DTO.OrderDTO;
import com.jsp.product.DTO.ProductDTO;
import com.jsp.product.config.AppConfig;
import com.jsp.product.service.OrderServiceImpl;
import com.jsp.product.service.ProductServiceImpl;

public class App {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();

		ProductServiceImpl productServiceImpl = context.getBean(ProductServiceImpl.class);
		OrderServiceImpl orderServiceImpl = context.getBean(OrderServiceImpl.class);
		List<OrderDTO> order = new ArrayList<OrderDTO>();
		
//		System.out.println("Enter Product Name");
//		String name = s.nextLine();
//		System.out.println("Enter product description");
//		String description = s.nextLine();
//		System.out.println("Set Product Price");
//		double price = s.nextDouble();
//		System.out.println("Enter product Quantity");
//		int quantity = s.nextInt();
//		ProductDTO productDTO = new ProductDTO(name, description, price, quantity);
//
//		productServiceImpl.addProduct(productDTO);

		System.out.println("Select Product");
		productList(productServiceImpl);
		addMore(s, orderServiceImpl, order);

	}

	public static void addMore(Scanner s, OrderServiceImpl oredrServiceImpl, List<OrderDTO> order) {
		order.add(order(s));
		System.out.println("Do you want to select more Product");
		System.out.println("1. Y");
		System.out.println("2. N");
		char Select = Character.toUpperCase(s.next().charAt(0));
		if (Select == 'Y') {
			addMore(s, oredrServiceImpl, order);
		} else if (Select == 'N') {
			oredrServiceImpl.processOrder(order);
		}
	}

	public static void productList(ProductServiceImpl productServiceImpl) {
		List<ProductDTO> listAllProduct = productServiceImpl.listAllProduct();
		int counter = 1;
		for (ProductDTO productDTO : listAllProduct) {
			System.out.print(counter);
			System.out.print("\t");
			System.out.print(productDTO.getName());
			System.out.print("\t\t");
			System.out.print(productDTO.getSkuCode());
			System.out.print("\t");
			System.out.println();
			counter++;
		}
	}

	public static OrderDTO order(Scanner s) {
		System.out.println("Enter Sku Code");
		long skuId = s.nextLong();
		System.out.println("Emter Quantity");
		int quantity = s.nextInt();
		return new OrderDTO(skuId, quantity);
	}
}
