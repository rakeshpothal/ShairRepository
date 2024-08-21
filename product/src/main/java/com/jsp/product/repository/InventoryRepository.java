package com.jsp.product.repository;

import org.springframework.stereotype.Component;

import com.jsp.product.entity.InventoryEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Component
public class InventoryRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void save(InventoryEntity inventoryEntity) {
		try {
			entityManager.persist(inventoryEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public InventoryEntity getInventoryBySkuCode(long skuCode) {
		String hqlQuery = "from InventoryEntity where skuCode=:skucode";
		Query query = entityManager.createQuery(hqlQuery);
		query.setParameter("skucode", skuCode);
		return (InventoryEntity) query.getSingleResult();
	}

	@Transactional
	public int updateProductQuantity(long skuCode, int quantity) {
		String skuCodeString = String.valueOf(skuCode);
		String hqlQuery = "update InventoryEntity set quantity=:quantity where skuCode=:skucode";
		Query query = entityManager.createQuery(hqlQuery);
		query.setParameter("quantity", quantity);
		query.setParameter("skucode", skuCodeString);
		int executeUpdate = query.executeUpdate();
		return executeUpdate;
	}
}
