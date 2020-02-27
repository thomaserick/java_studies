package com.tef.resource;



import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.tef.controller.ProductController;
import com.tef.entity.Product;
import com.tef.exception.AuthenticationException;

import java.util.List;


@Path("/products")
@ValidateOnExecution
public class ProductResource {

	private static final String CHARSET_UTF8 = ";charset=utf-8";
		
	private ProductController controller;

	public ProductResource() {
		controller = new ProductController();		
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
		return controller.list();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product productId(@PathParam("id") Integer id) {			
		return controller.findById(id);
	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.APPLICATION_JSON)
	public void addProduct(Product product) throws AuthenticationException {	
			 controller.save(product);	
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.APPLICATION_JSON)	
	public void editProduct(@PathParam("id") Integer id, Product product) throws AuthenticationException {	
		  controller.save(product);	
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public void deleteProduct(@PathParam("id") Integer id) {
		controller.delete(id);
	}

}
