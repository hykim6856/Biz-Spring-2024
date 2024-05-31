package com.callor.gallery;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.models.GalleryVO;
import com.callor.gallery.service.GalleryService;
import com.callor.gallery.utils.Names;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	
	private final GalleryService galleryService;
	
	public HomeController(GalleryService galleryService) {
		super();
		this.galleryService = galleryService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	
		
		return "home";
	}
	
	/*
	 * Single File을 controller 에서 받을 때는 MultipartFile 을 사용하여 받고
	 * 이때는 @RequestParam("name") 속성을 붙여준다.
	 * 
	 * 하지만 MultiFile 을 Controller 에서 받을때는 
	 * MultipartHttpServletRequest 를 사용하여 받고 
	 * 이때는 절대 @RequestParam() 속성을 사용해서는 안된다.
	 */
	@PostMapping(value="/")
	public String home(GalleryVO galleryVO, MultipartHttpServletRequest files) {
		log.debug("Gallery{}", galleryVO.toString());
		
		// files:form 의 input type="file" 의 name 속성을 사용
		List<MultipartFile> fileList = files.getFiles(Names.FILES);
		for(MultipartFile file : fileList) {
			log.debug("파일 {}" ,file.getOriginalFilename());
		}
		
		galleryService.createGallerys(galleryVO, files);
	
		return "home";
	}
	
}
