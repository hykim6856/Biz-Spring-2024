package com.callor.gallery.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.gallery.models.GalleryVO;

public interface GalleryDao {
	@Select("SELECT * FROM tbl_gallerys ORDER BY g_date DESC, g_time DESC")
	public List<GalleryVO> selectAll();
	@Select("SELECT * FROM tbl_gallerys WHERE g_id =#{id}")
	public GalleryVO findById(String id);
	
	public void create_table();

	public int insert(GalleryVO galleryVO);
}
