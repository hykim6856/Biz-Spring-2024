package com.callor.gallery.dao;

import com.callor.gallery.models.GalleryVO;

public interface GalleryDao {

	public void create_table();

	public int insert(GalleryVO galleryVO);
}
