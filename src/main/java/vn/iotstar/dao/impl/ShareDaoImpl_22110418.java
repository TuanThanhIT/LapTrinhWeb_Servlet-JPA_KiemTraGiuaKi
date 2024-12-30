package vn.iotstar.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import vn.iotstar.configs.JPAConfig_22110418;
import vn.iotstar.dao.IShareDao_22110418;

public class ShareDaoImpl_22110418 implements IShareDao_22110418{

	@Override
	public int CountShareVideo(int videoId) {
		EntityManager enma = JPAConfig_22110418.getEntityManager();
		String jpql = "SELECT COUNT(c) FROM Shares c WHERE c.video.videoId = :videoId";
		Query query = enma.createQuery(jpql);
		query.setParameter("videoId", videoId); // Gán tham số bookid
		return ((Long) query.getSingleResult()).intValue();
	}

	
}
