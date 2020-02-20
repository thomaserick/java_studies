package com.tef.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tef.entity.Product;

public class ProductController {
	

	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	
	
	public ProductController() {
		entityManagerFactory = Persistence.createEntityManagerFactory("appServer");
		entityManager = entityManagerFactory.createEntityManager();		
	}
	
	public Product save(Product product) {
		
		entityManager.getTransaction().begin();
		entityManager.persist(product);
		entityManager.getTransaction().commit();
		entityManagerFactory.close();		
		
		return product;
	}

}
