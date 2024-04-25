package com.callor.gallery.service.impl;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.service.FileUploadService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileUploadServiceImpl implements FileUploadService {
	private final String folder;

	private final ServletContext context;

	// 스프링에서 제공하는 프로젝트 컨텐츠 정보를 담고있는 객체

	public FileUploadServiceImpl(ServletContext context) {
		super();
		this.context = context;

		
		// 톰캣 폴더가 아닌 서버의 로컬 스토리지의 임의의폴더
		folder = "/app/upload";
	}

	@Override
	public String fileUpload(MultipartFile file) throws Exception {

		String originalFileName = file.getOriginalFilename();

		if (originalFileName.isEmpty()) {
			return null;
		}

		/*
		 * context. getRealPath("path) 이 method 는 실행중인 서버의 work folder 를 가리킨다. 서버가 정상적으로
		 * 실행되는 동안에는 아무런 문제 없이 이 폴더에 파일을 저장하거나, 읽기가 가능하다. 하지만 tomcat workDirectory Clean
		 * 을 실행하면 이 폴더는 삭제되어버린다. 파일을 업로드할때 절대 이 폴더에 저장하면 안된다.
		 */
		/*
		 * 프로젝트 컨텍스트루트/스태틱/업로드 폴더 정보 지정하기 실제로는 프로젝트/웹앱/스태틱/업로드 폴더를 사용한다.
		 */
//		String folder = context.getRealPath("/static/upload");
//		log.debug("업로드할 폴더",folder);
//		

		File path = new File(folder);
		if (!path.exists()) {
			path.mkdirs();
		}

		// 폴더이름 +파일 이름을 결합하여 업로드할 파일 정보를 생성하여
		// 업로드 파일 객체에 저장

		// 같은 이름의 파일을 업로드하여 기존파일을 망가뜨리는거나ㅏ
		String uuid = UUID.randomUUID().toString();
		String upLoadFileName = String.format("%s-%s", uuid, originalFileName);

		File upLoadFile = new File(folder, upLoadFileName);

		// 파일을 업로드 파일 정보로 복사하라
		// 업로드를 실행하라.
		file.transferTo(upLoadFile);

//실제저장된 파일의 이름을 리턴
		return upLoadFileName;
	}

	@Override
	public List<String> filesUpload(MultipartHttpServletRequest files) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
