package org.niit.ellebackend2.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.niit.ellebackend2.dao.CategoryDAO;
import org.niit.ellebackend2.dto.Category;
import org.springframework.stereotype.Repository;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	private static List<Category> categories = new ArrayList<>();
	 
	static {
		Category category = new Category();
		
		//adding first category
		category.setId(1);
		category.setName("Ethnic");
		category.setDescription("Ethinc is traditional wear");
		category.setImageURL("tom1.png");
		
		categories.add(category);
		
		
		
		//adding second category
		category = new Category();
		category.setId(2);
		category.setName("Western");
		category.setDescription("Western is cool to wear");
		category.setImageURL("tom2.png");
		
		categories.add(category);
		
		
		
		//adding third category
		category = new Category();
		category.setId(3);
		category.setName("Casual");
		category.setDescription("Staying casual is also an outfit");
		category.setImageURL("tom3.png");
		
		categories.add(category);
		
		
	}

	
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

}
