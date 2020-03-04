package com.tef.controller;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;

import com.tef.connection.ConnectionFactory;
import com.tef.entity.MovementProduct;
import com.tef.entity.Product;
import com.tef.exception.AuthenticationException;
import com.tef.exception.InvalidRequest;

@RequestScoped
public class MovementProductController {

	private EntityManager entityManager = ConnectionFactory.getConnection();

	public MovementProductController() {
	}

	public Product save(Integer idProduct, MovementProduct movementProduct) throws AuthenticationException {

		Product product = new ProductController().findById(idProduct);
		movementProduct.setProduct(product);
		movementProduct.setDateTime(new Date());
		product.getMovementProducts().add(movementProduct);

		if (movementProduct.getProduct().getId() == null) {
			throw new InvalidRequest("Produto não vinculado!");
		}

		try {

			entityManager.getTransaction().begin();
			entityManager.persist(movementProduct);
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();

		} finally {
			entityManager.close();
		}

		return product;
	}

	public Product delete(Integer idProduct, Integer idMovement) {

		Product product = new ProductController().findById(idProduct);

		try {
			MovementProduct movementProduct = entityManager.find(MovementProduct.class, idMovement);
			// Remove o objeto
			product.getMovementProducts().remove(movementProduct);
			entityManager.getTransaction().begin();
			
			entityManager.remove(movementProduct);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}

		return product;
	}

}
