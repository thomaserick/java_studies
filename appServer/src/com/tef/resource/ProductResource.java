package com.tef.resource;

import com.tef.controller.ProductController;
import com.tef.entity.Product;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


import java.util.List;


@Path("/products")
public class ProductResource {

	private static final String CHARSET_UTF8 = ";charset=utf-8";

	// Gerenciador de entidade
	
	@Inject
	private ProductController controller;

	public ProductResource() {
	

	}

	@GET
	@Produces("text/plain")
	public String api() {
		return "Hello World";
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> listProducts() {
		Query query = entityManager.createQuery("SELECT p FROM Product p");
		return query.getResultList();

	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product productId(@PathParam("id") Integer id) {
		return entityManager.find(Product.class, id);
	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.APPLICATION_JSON)
	public Product addProduct(Product product) {
		entityManager.persist(product);
		return product;

	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public Product editProduct(@PathParam("id") Integer id, Product product) {
		entityManager.merge(product);
		return product;
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public void deleteProduct(@PathParam("id") Integer id) {
		entityManager.remove(productId(id));
	}

}
