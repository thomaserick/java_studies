package com.tef.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;

import com.tef.connection.ConnectionFactory;
import com.tef.entity.Product;
import com.tef.exception.AuthenticationException;
import com.tef.exception.EntityNotFound;
import com.tef.exception.InvalidRequest;

@RequestScoped
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
	
	public void save(Product product) throws AuthenticationException {
		
		if (product.getDescription().length() < 3)
		{
			throw new InvalidRequest("Description cannot be less than 3 characters.");
		}
		
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
			e.printStackTrace();
					
		} finally {
			entityManager.close();			
		}	
		
		
		
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
