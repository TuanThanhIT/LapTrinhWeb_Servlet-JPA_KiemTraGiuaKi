package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.ICategoryDao_22110418;
import vn.iotstar.dao.impl.CategoryDaoImpl_22110418;
import vn.iotstar.entity.Category;
import vn.iotstar.services.ICategoryService_22110418;

public class CategoryService_22110418 implements ICategoryService_22110418{
	
	ICategoryDao_22110418 cateDao = new CategoryDaoImpl_22110418();
	
	@Override
	public int count() {
		return cateDao.count();
	}

	@Override
	public List<Category> findByCategoryname(String catname) {
		return cateDao.findByCategoryname(catname);
	}

	@Override
	public List<Category> findAll() {
		return cateDao.findAll();
	}

	@Override
	public Category findById(int cateid) {
		return cateDao.findById(cateid);
	}

	@Override
	public void delete(int cateid) throws Exception {
		cateDao.delete(cateid);
		
	}

	@Override
	public void update(Category category) {
		cateDao.update(category);
		
	}

	@Override
	public void insert(Category category) {
		cateDao.insert(category);
		
	}

	@Override
	public List<Category> findAllCategory() {
		return cateDao.findAllCategory();
	}

	@Override
	public List<Category> findAll(int page, int pagesize) {
		return cateDao.findAll(page, pagesize);
	}

	@Override
	public long getCategoryCount() {
		return cateDao.getCategoryCount();
	}
	
	

}
