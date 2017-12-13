package org.niit.ellebackend2.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.niit.ellebackend2.dao.ProductDAO;
import org.niit.ellebackend2.dto.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init() {
	    context = new AnnotationConfigApplicationContext();
	    context.scan("org.niit.ellebackend2");
	    context.refresh();
	    productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	/*@Test
	public void testCRUDProduct() {
		
		//create operation
		product = new Product();
		
		product.setName("Lehenga");
		product.setBrand("Soch");
		product.setDescription("Made from Pure of the purest fabric");
		product.setUnitPrice(49000);
		product.setActive(true);
		product.setCategoryId(1);
		product.setSupplierId(1);
	
		assertEquals("Something went wrong while inserting a new product! ",true,productDAO.add(product));
		
		//reading and updating the category
		product = productDAO.get(2);
		product.setName("Dabaang");
		assertEquals("Something went wrong while updating the existing record! ",true,productDAO.update(product));
		assertEquals("Something went wrong while deleting the existing record! ",true,productDAO.delete(product));
		
		//list
		assertEquals("Something went wrong while fetching the list of products! ",6,productDAO.list().size());
		
	}	*/	
	
	@Test
	public void testListActiveProducts() {
	assertEquals("Something went wrong while fetching the list of products! ",5,productDAO.listActiveProducts().size());
	}
	@Test
	public void testListActiveProductsByCategory() {
	assertEquals("Something went wrong while fetching the list of products! ",2,productDAO.listActiveProductsByCategory(3).size());
	
	assertEquals("Something went wrong while fetching the list of products! ",1,productDAO.listActiveProductsByCategory(2).size());
	}
	@Test
	public void testGetLatestActiveProduct() {
	assertEquals("Something went wrong while fetching the list of products! ",3,productDAO.getLatestActiveProducts(3).size());
	}

}
