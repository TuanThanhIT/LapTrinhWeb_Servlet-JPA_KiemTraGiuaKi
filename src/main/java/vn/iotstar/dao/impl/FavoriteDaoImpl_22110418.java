package vn.iotstar.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import vn.iotstar.configs.JPAConfig_22110418;
import vn.iotstar.dao.IFavoriteDao_22110418;

public class FavoriteDaoImpl_22110418 implements IFavoriteDao_22110418{

	@Override
	public int CountLikeVideo(int videoId) {
		EntityManager enma = JPAConfig_22110418.getEntityManager();
		String jpql = "SELECT COUNT(c) FROM Favorites c WHERE c.video.videoId = :videoId";
		Query query = enma.createQuery(jpql);
		query.setParameter("videoId", videoId); // Gán tham số bookid
		return ((Long) query.getSingleResult()).intValue();
	}
	
	
	 
   
 
    

}
