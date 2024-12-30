package vn.iotstar.dao;

import java.util.List;
import vn.iotstar.entity.Videos;

public interface IVideoDao_22110418 {
	int count();

	List<Videos> findAll(int page, int pagesize);

	List<Videos> findByVideoName(String vidname);

	List<Videos> findAll();

	Videos findById(int videoid);

	void delete(String videoid) throws Exception;

	void update(Videos video);

	void insert(Videos video);

	long getVideoCount();
}
