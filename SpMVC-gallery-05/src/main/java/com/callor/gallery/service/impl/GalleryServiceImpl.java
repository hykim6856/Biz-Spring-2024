package com.callor.gallery.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.dao.GalleryDao;
import com.callor.gallery.models.GalleryVO;
import com.callor.gallery.models.ImagesVO;
import com.callor.gallery.service.FileService;
import com.callor.gallery.service.GalleryService;
import com.callor.gallery.utils.Names;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GalleryServiceImpl implements GalleryService {

	private final FileService fileService;
	private final GalleryDao galleryDao;
	public GalleryServiceImpl(FileService fileService, GalleryDao galleryDao) {
		this.fileService = fileService;
		this.galleryDao = galleryDao;
	}

	@Autowired
	public void create_table() {
		galleryDao.create_table();
	}

	@Override
	public int createGallerys(GalleryVO galleryVO, MultipartHttpServletRequest files) {
		List<MultipartFile> fileList = files.getFiles(Names.FILES);
		List<ImagesVO> images = new ArrayList<>();

		String g_id = UUID.randomUUID().toString();
		galleryVO.setG_id(g_id);

		if (fileList.size() > 1) {
			images = fileService.filesUp(files);
			galleryVO.setG_image(images.get(0).getI_up_image());
		} else {
			String name = fileService.fileUp(fileList.get(0));
			galleryVO.setG_image(name);
		}
		log.debug("갤러리 {}", galleryVO.toString());
		return 0;
	}

}
