package vn.iotstar.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import vn.iotstar.configs.JPAConfig_22110418;
import vn.iotstar.dao.ICategoryDao_22110418;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.Videos;

public class CategoryDaoImpl_22110418 implements ICategoryDao_22110418{

	@Override
	public int count() {
		EntityManager enma = JPAConfig_22110418.getEntityManager();
		String jpql = "SELECT count(c) FROM Category c";
		Query query = enma.createQuery(jpql);
		return ((Long) query.getSingleResult()).intValue();
	}
	
	@Override
	public List<Category> findAllCategory() {
		EntityManager em = JPAConfig_22110418.getEntityManager();
		TypedQuery<Category> query = em.createQuery("SELECT a FROM Category a JOIN FETCH a.videos", Category.class);
		return query.getResultList();
	}

	@Override
	public List<Category> findByCategoryname(String catname) {
		EntityManager enma = JPAConfig_22110418.getEntityManager();
		String jpql = "SELECT c FROM Category c WHERE c.catename like :catname";
		TypedQuery<Category> query = enma.createQuery(jpql, Category.class);
		query.setParameter("catename", "%" + catname + "%");
		return query.getResultList();
	}

	@Override
	public List<Category> findAll() {
		EntityManager enma = JPAConfig_22110418.getEntityManager();
		String jpql = "Select c FROM Category c";
		TypedQuery<Category> query = enma.createQuery(jpql, Category.class);
		return query.getResultList();
	}

	@Override
	public Category findById(int cateid) {
		EntityManager enma = JPAConfig_22110418.getEntityManager();
		Category category = enma.find(Category.class, cateid);
		return category;
	}

	@Override
	public void delete(int cateid) throws Exception {
		EntityManager enma = JPAConfig_22110418.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			// gọi phuong thức để insert, update, delete
			Category category = enma.find(Category.class, cateid);
			if (category != null) {
				enma.remove(category);
			} else {
				throw new Exception("Không tìm thấy");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
		
	}

	@Override
	public void update(Category category) {
		EntityManager enma = JPAConfig_22110418.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			// gọi phuong thức để insert, update, delete
			enma.merge(category);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
		
	}

	@Override
	public void insert(Category category) {
		EntityManager enma = JPAConfig_22110418.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			// gọi phuong thức để insert, update, delete
			enma.persist(category);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
		
	}

	@Override
	public List<Category> findAll(int page, int pagesize) {
		EntityManager enma = JPAConfig_22110418.getEntityManager();
		String queryStr = "SELECT a FROM Category a";
		Query query = enma.createQuery(queryStr, Category.class);
		query.setFirstResult((page - 1) * pagesize); // Tính vị trí bắt đầu
		query.setMaxResults(pagesize); // Giới hạn số kết quả trả về
		return query.getResultList();
	}
	
	@Override
	public long getCategoryCount() {
		EntityManager entityManager = JPAConfig_22110418.getEntityManager();
		String queryStr = "SELECT COUNT(a) FROM Category a";
		Query query = entityManager.createQuery(queryStr);
		return (long) query.getSingleResult();
	}


	

	
	
	

	

	

}


