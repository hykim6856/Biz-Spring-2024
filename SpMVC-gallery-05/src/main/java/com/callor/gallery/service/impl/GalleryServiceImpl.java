package com.callor.gallery.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.dao.GalleryDao;
import com.callor.gallery.dao.ImageDao;
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
	private final ImageDao imageDao;
	public GalleryServiceImpl(FileService fileService, GalleryDao galleryDao, ImageDao imageDao) {
		super();
		this.fileService = fileService;
		this.galleryDao = galleryDao;
		this.imageDao = imageDao;
	}

	@Autowired
	public void create_table() {
		galleryDao.create_table();
		imageDao.create_table();
	}

	@Override
	public int createGallerys(GalleryVO galleryVO, MultipartHttpServletRequest files) {
		List<MultipartFile> fileList = files.getFiles(Names.FILES);
		List<ImagesVO> images = new ArrayList<>();

//		String g_id = UUID.randomUUID().toString();
//		galleryVO.setG_id(g_id);
		this.setGalleryVO(galleryVO);

		if (fileList.size() > 1) {
			images = fileService.filesUp(files);
			galleryVO.setG_image(images.get(0).getI_up_image());
		} else {
			String name = fileService.fileUp(fileList.get(0));
			galleryVO.setG_image(name);
			int ret = galleryDao.insert(galleryVO);
		}
		log.debug("갤러리 {}", galleryVO.toString());
		return 0;
	}
	
	/*
	 * GalleryVO 객체를 매개변수로 전달받아 
	 * 각 요소속성(g_id,g_date,g_time)을 변경하고 있다.
	 * 이때 setGalleryVO() method 는 GalleryVO 객체를 Call By Reference로
	 * 받은 것과 동일하게 작동된다.
	 */
	private void setGalleryVO(GalleryVO galleryVO) {
		String g_id = UUID.randomUUID().toString();
		
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter today = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		galleryVO.setG_id(g_id);
		galleryVO.setG_date(dateTime.format(today));
		galleryVO.setG_time(dateTime.format(time));
	}

}
