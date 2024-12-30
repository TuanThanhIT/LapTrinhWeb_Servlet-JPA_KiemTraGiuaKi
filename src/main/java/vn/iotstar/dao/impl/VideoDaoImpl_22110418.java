package vn.iotstar.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import vn.iotstar.configs.JPAConfig_22110418;
import vn.iotstar.dao.IVideoDao_22110418;
import vn.iotstar.entity.Videos;

public class VideoDaoImpl_22110418 implements IVideoDao_22110418{

	@Override
	public int count() {
		EntityManager enma = JPAConfig_22110418.getEntityManager();
		String jpql = "SELECT count(c) FROM Videos c";
		Query query = enma.createQuery(jpql);
		return ((Long) query.getSingleResult()).intValue();
	}

	@Override
	public List<Videos> findAll(int page, int pagesize) {
		EntityManager enma = JPAConfig_22110418.getEntityManager();
		String queryStr = "SELECT a FROM Videos a";
		Query query = enma.createQuery(queryStr, Videos.class);
		query.setFirstResult((page - 1) * pagesize); // Tính vị trí bắt đầu
		query.setMaxResults(pagesize); // Giới hạn số kết quả trả về
		return query.getResultList();
	}
	
	@Override
	public long getVideoCount() {
		EntityManager entityManager = JPAConfig_22110418.getEntityManager();
		String queryStr = "SELECT COUNT(a) FROM Videos a";
		Query query = entityManager.createQuery(queryStr);
		return (long) query.getSingleResult();
	}
	@Override
	public List<Videos> findByVideoName(String vidname) {
		EntityManager enma = JPAConfig_22110418.getEntityManager();
		String jpql = "SELECT c FROM Videos c WHERE c.catename like :vidname";
		TypedQuery<Videos> query = enma.createQuery(jpql, Videos.class);
		query.setParameter("catename", "%" + vidname + "%");
		return query.getResultList();
	}

	@Override
	public List<Videos> findAll() {
		EntityManager enma = JPAConfig_22110418.getEntityManager();
		String jqpl = "Select c From Videos c";
		TypedQuery<Videos> query = enma.createQuery(jqpl, Videos.class);
		return query.getResultList();
	}

	@Override
	public Videos findById(int videoid) {
		EntityManager enma = JPAConfig_22110418.getEntityManager();
		Videos video = enma.find(Videos.class, videoid);
		return video;
	}

	@Override
	public void delete(String videoid) throws Exception {
		EntityManager enma = JPAConfig_22110418.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			Videos video = enma.find(Videos.class, videoid);
			if (video != null) {
				enma.remove(video);
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
	public void update(Videos video) {
		EntityManager enma = JPAConfig_22110418.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(video);
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
	public void insert(Videos video) {
		EntityManager enma = JPAConfig_22110418.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(video);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
		
	}
	
	
	
			
}
