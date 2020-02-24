package com.tef.controller;

import java.util.List;

import javax.persistence.EntityManager;


import com.tef.connection.ConnectionFactory;
import com.tef.entity.Product;

public class ProductController {
	
	
	private EntityManager entityManager = ConnectionFactory.getConnection();

	public ProductController() {}
		
	
	@SuppressWarnings("unchecked")
	public List<Product> list(){	
		List<Product> lista = null; 		
		try {
			lista = entityManager.createQuery("FROM Product p").getResultList();
		} catch (Exception e) {
			e.printStackTrace();		   
		} finally {
			entityManager.close();			
		}		
		return lista;		
	}
	
	public Product save(Product product) {
		
		
		try {
						
			entityManager.getTransaction().begin();
			
			if(product.getId() == null) {					
				entityManager.persist(product);
			} else {
				entityManager.merge(product);
			}			
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();			
		}
		return product;
	}
	
	
	public Product findById(Integer id) {
		
		Product product = null;
		
		try {			
			product = entityManager.find(Product.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
				
		return product;
		
	}
	
	public void delete(Integer id) {
		
		try {
			Product product = entityManager.find(Product.class, id);
			entityManager.getTransaction().begin();
			entityManager.remove(product);
			entityManager.getTransaction().commit();			
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();			
		}		
	}

}
