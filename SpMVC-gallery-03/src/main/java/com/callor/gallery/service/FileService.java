package com.callor.gallery.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.models.ImageVO;

public interface FileService {

	//싱글
	public String fileUp(MultipartFile file) throws Exception;
	//멀티
	public List<ImageVO> filesUp(MultipartHttpServletRequest files) throws Exception;
}
