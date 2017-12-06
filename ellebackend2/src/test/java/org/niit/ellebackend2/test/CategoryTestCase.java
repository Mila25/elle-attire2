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
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("org.niit.ellebackend2");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		
	}
	
	
	@Test
	public void testAddCategory() {
		
		category = new Category();
		
		category.setName("Ethnic");
		category.setDescription("Ethinc is traditional wear");
		category.setImageURL("tom1.png");
		
		assertEquals("successfully added category inside table", true,categoryDAO.add(category));
		
		
	
	}
	
	/*@Test
	public void testGetCategory() {
		category = categoryDAO.get();
	*/ 
	
}


	
