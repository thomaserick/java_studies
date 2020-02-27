package test.java;

import org.junit.jupiter.api.Test;


import com.tef.controller.ProductController;
import com.tef.entity.Category;
import com.tef.entity.Product;
import com.tef.exception.AuthenticationException;

public class TestProduct {

	
@Test
public void testSave() throws AuthenticationException {	
	Product product = new Product();
	Category category = new Category();
	category.setId(2);
	product.setDescription("Cerveja");
	product.setPrice(2.0);	
	product.setCategory(category);
	ProductController controller = new ProductController();	
	controller.save(product) ;
	
}


@Test
public void testUpdate() {
	
	Product product = new Product();
	
	Category category = new Category();
	category.setId(1);
	
	product.setId(2);
	product.setDescription("Manteiga");
	product.setPrice(2.0);
	product.setCategory(category);
	ProductController controller = new ProductController();	
	controller.save(product);	
	
}

@Test
public void testFindById() {		 
	ProductController controller = new ProductController();	
	Product product = controller.findById(1);	
	System.out.println("Descrição:" + product.getDescription());
}


@Test
public void testList() {
	ProductController controller = new ProductController();	
	
	for (Product p: controller.list()) {
		System.out.println("Descrição:" +  p.getDescription());		
		System.out.println("Descrição:" +  p.getCategory().getDescription());		
	}
	
	
}

@Test
public void testDelete() {
	ProductController controller = new ProductController();	
	controller.delete(2);	
}
	


	
}
