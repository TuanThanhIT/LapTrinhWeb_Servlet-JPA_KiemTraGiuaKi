package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.entity.Category;

public interface ICategoryDao_22110418 {
	int count();

	List<Category> findByCategoryname(String catname);

	List<Category> findAll();

	Category findById(int cateid);

	void delete(int cateid) throws Exception;

	void update(Category category);

	void insert(Category category);

	List<Category> findAllCategory();
	
	List<Category> findAll(int page, int pagesize);

	long getCategoryCount();
	
	
}
