package com.jsp.product.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jsp.product.entity.ProductEntity;

import jakarta.persistence.EntityManager;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Component
public class ProductRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void save(ProductEntity productEntity) {
		try {
			entityManager.persist(productEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ProductEntity getProductBySkuCode(long skuCode) {
		String hqlQury = "from ProductEntity where skuCode=:skucode";
		Query query = entityManager.createQuery(hqlQury);
		query.setParameter("skucode", skuCode);
		return (ProductEntity) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<ProductEntity> getAllProduct() {
		String hqlQuery = "from ProductEntity";
		Query query = entityManager.createQuery(hqlQuery, ProductEntity.class);
		return query.getResultList();
	}
}
