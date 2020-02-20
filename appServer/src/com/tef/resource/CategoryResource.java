package com.tef.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tef.controller.CategoryController;
import com.tef.entity.Category;

@Path("/categorys")
public class CategoryResource {

	private static final String CHARSET_UTF8 = ";charset=utf-8";

	private CategoryController controller;

	public CategoryResource() {
		controller = new CategoryController();
	}

	@GET
	@Produces("text/plain")
	public String api() {
		return "Categoria";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public List<Category> listCategory() {
		return controller.list();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Category categoryId(Integer id) {
		return controller.findById(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/add")
	public Category saveCategory(Category category) {
		return controller.save(category);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Category editCategory(@PathParam("id")Integer id, Category category) {		
		return controller.save(category);		
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void deleteCategory(@PathParam("id") Integer id) {
		controller.delete(id);
	}

}
