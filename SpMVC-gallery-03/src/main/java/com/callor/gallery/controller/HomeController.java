package com.callor.gallery.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.dao.GalleryDao;
import com.callor.gallery.models.GalleryVO;
import com.callor.gallery.service.GalleryService;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class HomeController {
	
	
	private final GalleryDao galleryDao;
	private final GalleryService galleryservice;
	
	
	
//	public HomeController(GalleryDao galleryDao) {
//		super();
//		this.galleryDao = galleryDao;
//	}
	public HomeController(GalleryDao galleryDao, GalleryService galleryservice) {
		super();
		this.galleryDao = galleryDao;
		this.galleryservice = galleryservice;
		this.galleryDao.create_table();
	}
	


	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
		return "input";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(MultipartHttpServletRequest files, GalleryVO galleryVO) {
		log.debug("Gallery {}", galleryVO.toString());
		//멀티파트http서블릿리퀘로 부터 파일리스트 추출. 
		List<MultipartFile> fileList = files.getFiles("files");
		log.debug("Image {}", fileList.get(0).getOriginalFilename());
	
		return "redirect:/";
	}
	
}
