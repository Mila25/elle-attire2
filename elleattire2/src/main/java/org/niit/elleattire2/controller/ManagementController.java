package org.niit.elleattire2.controller;

import java.util.List;

import org.niit.ellebackend2.dao.CategoryDAO;
import org.niit.ellebackend2.dto.Category;
import org.niit.ellebackend2.dto.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage")
public class ManagementController {


	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private CategoryDAO productDAO;
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProducts() {
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickMAnageProducts", true);
		mv.addObject("title", "Manage Products");
		Product  nProduct = new Product();
		
		//set few of the fields
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		mv.addObject("product", nProduct);
		
		
		return mv;
	}
	//handling product submission
	@RequestMapping(value="/products", method = RequestMethod.POST)
	public String handlePRoductSubmission() {
		
		return "redirect:/manage/products";
	}
	
	// returning categories for all request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		
		return categoryDAO.list();
	}
	
}
