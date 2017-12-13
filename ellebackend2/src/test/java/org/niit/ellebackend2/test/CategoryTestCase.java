package org.niit.ellebackend2.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.niit.ellebackend2.dao.CategoryDAO;
import org.niit.ellebackend2.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static CategoryDAO categoryDAO;
	@Autowired
	private Category category;
	@BeforeClass
	public static void init() throws Exception {
	    org.h2.tools.Server.createTcpServer().start();
	    context = new AnnotationConfigApplicationContext();
	    context.scan("org.niit.ellebackend2");
	    context.refresh();
	    categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	/*@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("org.niit.ellebackend2");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		
	}
	*/
	
	/*@Test
	public void testAddCategory() {
		
		category = new Category();
		
		category.setName("Croptops");
		category.setDescription("Itz trending");
		category.setImageURL("tom18.png");
		
		assertEquals("Successfully added category inside table", true,categoryDAO.add(category));
		
		
		category = new Category();
		
		category.setName("Lehenga");
		category.setDescription("Itz Gorgeous");
		category.setImageURL("tom82.png");
		
		assertEquals("Successfully added category inside table", true,categoryDAO.add(category));
	}*/
	
	/*@Test
	public void testGetCategory() {
		category = categoryDAO.get(2);
		assertEquals("Successfully fetched single category from table", "Lehenga",category.getName());
	} */
	
	
	/*@Test
	public void testUpdateCategory() {
		category = categoryDAO.get(2);
		category.setName("TV");
		assertEquals("Successfully Updated single category in the table", true,categoryDAO.update(category));
	} */
	
	/*@Test
	public void testDeleteCategory() {
		category = categoryDAO.get(2);
		
		assertEquals("Successfully Updated single category in the table", true,categoryDAO.delete(category));
	}*/
	
	/*@Test
	public void testListCategory() {
		
		assertEquals("Successfully fetched the list of categories from the table", 2,categoryDAO.list().size());
	}*/
	
	//CRUD operation
	@Test
	public void testCRUDCategory() {
		
		category = new Category();
		
		category.setName("Ethnic");
		category.setDescription("Ethinc is traditional wear");
		category.setImageURL("tom1.png");

		assertEquals("Successfully added category inside table", true,categoryDAO.add(category));
		
		category = new Category();
		
		category.setName("Western");
		category.setDescription("It is still Special in Clothing");
		category.setImageURL("tom2.png");

		assertEquals("Successfully added category inside table", true,categoryDAO.add(category));
		
		//Fetching and Updating the category
		category = categoryDAO.get(2);
		category.setName("Lehenga");
		assertEquals("Successfully Updated single category in the table", true,categoryDAO.update(category));
		
		//Deleting the category
		
		assertEquals("Successfully Updated single category in the table", true,categoryDAO.delete(category));
		
		//Fetching the list
		assertEquals("Successfully fetched the list of categories from the table", 1,categoryDAO.list().size());
	}
	
}



	
