package org.niit.ellebackend2.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.niit.ellebackend2.dao.CartLineDAO;
import org.niit.ellebackend2.dao.ProductDAO;
import org.niit.ellebackend2.dao.UserDAO;
import org.niit.ellebackend2.dto.Cart;
import org.niit.ellebackend2.dto.CartLine;
import org.niit.ellebackend2.dto.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CartLineTestCase {

	

	private static AnnotationConfigApplicationContext context;
	
	
	private static CartLineDAO cartLineDAO;
	private static ProductDAO productDAO;
	private static UserDAO userDAO;
	
	
	private CartLine cartLine = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("org.niit.ellebackend2");
		context.refresh();
		cartLineDAO = (CartLineDAO)context.getBean("cartLineDAO");
		productDAO = (ProductDAO)context.getBean("productDAO");
		userDAO = (UserDAO)context.getBean("userDAO");
	}
	
/*	
	@Test
	public void testAddCartLine() {
		
		// fetch the user and then cart of that user
		User user = userDAO.getByEmail("absr@gmail.com");		
		Cart cart = user.getCart();
		
		// fetch the product 
		Product product = productDAO.get(2);
		
		// Create a new CartLine
		cartLine = new CartLine();
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		cartLine.setProductCount(1);
		
		double oldTotal = cartLine.getTotal();		
		
		cartLine.setTotal(product.getUnitPrice() * cartLine.getProductCount());
		
		cart.setCartLines(cart.getCartLines() + 1);
		cart.setGrandTotal(cart.getGrandTotal() + (cartLine.getTotal() - oldTotal));
		
		assertEquals("Failed to add the CartLine!",true, cartLineDAO.add(cartLine));
		assertEquals("Failed to update the cart!",true, userDAO.updateCart(cart));
		
	}
	
	*/
	
	@Test
	public void testUpdateCartLine() {

		// fetch the user and then cart of that user
		User user = userDAO.getByEmail("absr@gmail.com");		
		
		Cart cart = user.getCart();
				
		cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), 2);
		
		cartLine.setProductCount(cartLine.getProductCount() + 1);
				
		double oldTotal = cartLine.getTotal();
				
		cartLine.setTotal(cartLine.getProduct().getUnitPrice() * cartLine.getProductCount());
		
		cart.setGrandTotal(cart.getGrandTotal() + (cartLine.getTotal() - oldTotal));
		
		assertEquals("Failed to update the CartLine!",true, cartLineDAO.update(cartLine));	

		
	}
	
	
	
}

