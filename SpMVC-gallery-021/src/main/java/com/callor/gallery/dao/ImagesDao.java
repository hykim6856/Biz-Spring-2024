package com.callor.gallery.dao;

import com.callor.gallery.models.GalleryVO;

public interface ImagesDao extends GenericDao<GalleryVO, String> {

	void create_table(String string);
	


	
}
