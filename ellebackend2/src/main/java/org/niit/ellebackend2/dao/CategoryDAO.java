package org.niit.ellebackend2.dao;

import java.util.List;

import org.niit.ellebackend2.dto.Category;

public interface CategoryDAO {

	
	List<Category> list();
	Category get(int id);
	boolean add(Category category);
	/*boolean update(Category category);
	boolean delete(Category category);*/
	
}
