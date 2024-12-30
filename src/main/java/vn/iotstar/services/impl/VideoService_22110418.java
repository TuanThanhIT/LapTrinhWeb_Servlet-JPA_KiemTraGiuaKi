package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.IVideoDao_22110418;
import vn.iotstar.dao.impl.VideoDaoImpl_22110418;
import vn.iotstar.entity.Videos;
import vn.iotstar.services.IVideoService_22110418;

public class VideoService_22110418 implements IVideoService_22110418{

	IVideoDao_22110418 videoDao = new VideoDaoImpl_22110418();
	@Override
	public int count() {
		return videoDao.count();
	}

	@Override
	public List<Videos> findAll(int page, int pagesize) {
		return videoDao.findAll(page, pagesize);
	}

	@Override
	public List<Videos> findByVideoName(String vidname) {
		return videoDao.findByVideoName(vidname);
	}

	@Override
	public List<Videos> findAll() {
		return videoDao.findAll();
	}

	@Override
	public Videos findById(int videoid) {
		return videoDao.findById(videoid);
	}

	@Override
	public void delete(String cateid) throws Exception {
		videoDao.delete(cateid);
		
	}

	@Override
	public void update(Videos video) {
		videoDao.update(video);
		
	}

	@Override
	public void insert(Videos video) {
		videoDao.insert(video);
		
	}

	@Override
	public long getVideoCount() {
		return videoDao.getVideoCount();
	}

}
