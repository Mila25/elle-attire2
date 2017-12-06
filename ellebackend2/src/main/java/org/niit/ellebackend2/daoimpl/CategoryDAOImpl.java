package org.niit.ellebackend2.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.niit.ellebackend2.dao.CategoryDAO;
import org.niit.ellebackend2.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("categoryDAO")
/*@Transactional*/
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category category = new Category();
		
		//adding first category
		category.setId(1);
		category.setName("Ethnic");
		category.setDescription("Ethinc is traditional wear");
		category.setImageURL("tom.png");
		
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

/*
 * Getting a single Category based on id
 * */
	
	@Override
	public Category get(int id) {
		
		//enhanced for loop
		for(Category category : categories) {
			if(category.getId() == id) return category;
		}
		return null;
		
	/*return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));	*/
		
	}


	@Override
	@Transactional
	public boolean add(Category category) {
		// TODO Auto-generated method stub
		try {
			// add the category to the database table
		
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	
	}


	/*@Override
	public boolean update(Category category) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		return false;
	}
*/
}
