package com.tef.controller;

import java.util.List;

import javax.persistence.EntityManager;

import com.tef.connection.ConnectionFactory;
import com.tef.entity.Category;

public class CategoryController {

	private EntityManager entityManager = ConnectionFactory.getConnection();

	@SuppressWarnings("unchecked")
	public List<Category> list() {
		List<Category> listCategory = null;
		try {
			listCategory = entityManager.createQuery("FROM Category c").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		return listCategory;
	}

	public Category save(Category category) {

		try {
			entityManager.getTransaction().begin();
			entityManager.persist(category);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}

		return category;
	}

	public Category findById(Integer id) {
		Category category = null;
		try {
			category = entityManager.find(Category.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		return category;
	}

	public void delete(Integer id) {
		Category category = null;
		try {
			entityManager.getTransaction().begin();
			category = entityManager.find(Category.class, id);
			entityManager.remove(category);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			entityManager.clear();
		}
	}

}
