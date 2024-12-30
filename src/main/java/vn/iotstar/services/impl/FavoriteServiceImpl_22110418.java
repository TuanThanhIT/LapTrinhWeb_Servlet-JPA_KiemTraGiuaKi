package vn.iotstar.services.impl;

import vn.iotstar.dao.IFavoriteDao_22110418;
import vn.iotstar.dao.impl.FavoriteDaoImpl_22110418;
import vn.iotstar.services.IFavoriteService_22110418;

public class FavoriteServiceImpl_22110418 implements IFavoriteService_22110418{
	
	IFavoriteDao_22110418 favoriteDao = new FavoriteDaoImpl_22110418();

	@Override
	public int CountLikeVideo(int videoId) {
		return favoriteDao.CountLikeVideo(videoId);
	}
}
