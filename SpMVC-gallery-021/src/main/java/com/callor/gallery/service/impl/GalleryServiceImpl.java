package com.callor.gallery.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.dao.GalleryDao;
import com.callor.gallery.dao.ImagesDao;
import com.callor.gallery.models.GalleryVO;
import com.callor.gallery.service.FileUploadService;
import com.callor.gallery.service.GalleryService;

@Service
public class GalleryServiceImpl implements GalleryService {

	private final GalleryDao galleryDao;
	private final FileUploadService fileUploadService;
	private final ImagesDao imagesDao;
	
	public GalleryServiceImpl(GalleryDao galleryDao, FileUploadService fileUploadService,ImagesDao imagesDao) {
		super();
		this.galleryDao = galleryDao;
		this.fileUploadService = fileUploadService;
		this.imagesDao = imagesDao;
		galleryDao.create_table(null);

	}
	
	@Autowired
	public void create_table() {
		galleryDao.create_table(null);
		imagesDao.create_table(null);
	}

	@Override
	public List<GalleryVO> selectAll() {

		return galleryDao.selectAll();
	}

	@Override
	public GalleryVO createGallery(GalleryVO galleryVO, MultipartFile image_file) throws Exception {
		
		galleryVO.setG_id(UUID.randomUUID().toString());

		galleryVO.setG_origin_image(image_file.getOriginalFilename());
		String fileName = fileUploadService.fileUpload(image_file);
		galleryVO.setG_up_image(fileName);

		LocalDateTime lt = LocalDateTime.now();
		DateTimeFormatter date = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		galleryVO.setG_date(lt.format(date));
		galleryVO.setG_time(lt.format(time));
		galleryVO.setG_auth("hykim6856@naver.com");
		
		int ret = galleryDao.insert(galleryVO);
		if (ret > 0) {
			return galleryVO;
		}

		return null;
	}

	@Override
	public List<GalleryVO> createGallery(GalleryVO galleryVO, MultipartHttpServletRequest image_files)
			throws Exception {
		
		List<String> result = fileUploadService.filesUpload(image_files);
		
		
		return null;
	}

}
