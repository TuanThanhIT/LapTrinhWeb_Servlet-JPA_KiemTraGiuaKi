package vn.iotstar.services.impl;

import vn.iotstar.dao.IShareDao_22110418;
import vn.iotstar.dao.impl.ShareDaoImpl_22110418;
import vn.iotstar.services.IShareService_22110418;

public class ShareServiceImpl_22110418 implements IShareService_22110418{

	IShareDao_22110418 shareDao = new ShareDaoImpl_22110418();
	
	@Override
	public int CountShareVideo(int videoId) {
		return shareDao.CountShareVideo(videoId);
	}

}
