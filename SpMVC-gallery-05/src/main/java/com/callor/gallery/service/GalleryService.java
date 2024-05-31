package com.callor.gallery.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.models.GalleryVO;

public interface GalleryService {

	public int createGallerys(GalleryVO galleryVO, MultipartHttpServletRequest files);
}
