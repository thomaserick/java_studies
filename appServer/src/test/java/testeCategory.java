package test.java;

import org.junit.jupiter.api.Test;

import com.tef.controller.CategoryController;
import com.tef.entity.Category;

public class testeCategory {
	
	
	@Test
	public void tCaregorySave() {
		Category category = new Category();
		category.setDescription("Verduras");
		
		CategoryController controller = new CategoryController();
		controller.save(category);	
	}
	
	@Test
	public void tCategoryDelete() {		
		CategoryController controller = new CategoryController();
		controller.delete(1);		
	}

	@Test
	public void tCategoryFind() {		
		CategoryController controller = new CategoryController();
		Category category = controller.findById(2);
		System.out.println(category);			
		
	}

	@Test
	public void tCategoryList() {
		
		CategoryController controller = new CategoryController();
		
		for (Category category : controller.list()) {
			System.out.println(category.getDescription());			
		}
		
		
	}
}
