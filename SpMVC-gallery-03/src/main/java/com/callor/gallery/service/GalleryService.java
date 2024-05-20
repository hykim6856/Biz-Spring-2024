package com.callor.gallery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.gallery.models.GalleryVO;

@Service
public interface GalleryService {

	public List<GalleryVO> selectAll();
	public int create_Gallery();
}
