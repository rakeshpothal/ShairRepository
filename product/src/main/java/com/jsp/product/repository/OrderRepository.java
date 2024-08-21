package com.jsp.product.repository;

import org.springframework.stereotype.Component;

import com.jsp.product.entity.OrderEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class OrderRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void save(OrderEntity orderEntity) {
		try {
			entityManager.persist(orderEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
