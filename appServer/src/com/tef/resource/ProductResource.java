package com.tef.resource;

import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.tef.controller.MovementProductController;
import com.tef.controller.ProductController;
import com.tef.entity.MovementProduct;
import com.tef.entity.Product;
import com.tef.exception.AuthenticationException;


import java.util.Date;
import java.util.List;

@Path("/products")
@ValidateOnExecution
public class ProductResource {

	private static final String CHARSET_UTF8 = ";charset=utf-8";

	private ProductController productController;
	
	private MovementProductController movementProductController;

	public ProductResource() {
		productController = new ProductController();	
		movementProductController = new MovementProductController();
	}

	@GET
	@Produces("text/plain")
	public String api() {
		return "Hello World";
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> listProducts() {
		return productController.list();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product productId(@PathParam("id") Integer id) {
		return productController.findById(id);
	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.APPLICATION_JSON)
	public void addProduct(Product product) throws AuthenticationException {
		productController.save(product);
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.APPLICATION_JSON)
	public void editProduct(@PathParam("id") Integer id, Product product) throws AuthenticationException {
		productController.save(product);
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public void deleteProduct(@PathParam("id") Integer id) {
		productController.delete(id);
	}

	@POST
	@Path("{id}/movement")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.APPLICATION_JSON)
	public Product addMoviment(@PathParam("id") Integer idProduct, MovementProduct movementProduct)
			throws AuthenticationException {
		
		return movementProductController.save(idProduct,movementProduct);
		
		
	
	}
	
	@DELETE
	@Path("{id}/movement/{idMovement}")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public Product deleteMoviment(@PathParam("id") Integer idProduct, @PathParam("idMovement") Integer idMovement) {		
		
		return movementProductController.delete(idProduct,idMovement);
		
	}
	

}
