package org.niit.ellebackend2.dao;

import java.util.List;

import org.niit.ellebackend2.dto.Category;

public interface CategoryDAO {

	Category get(int id);
	List<Category> list();
	
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	
}
