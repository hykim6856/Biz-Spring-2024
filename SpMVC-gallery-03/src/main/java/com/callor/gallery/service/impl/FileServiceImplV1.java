package com.callor.gallery.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileUpload;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.config.QualifierConfig;
import com.callor.gallery.models.ImageVO;
import com.callor.gallery.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifierConfig.SERVICE.FILE_SERVICE_V1)
public class FileServiceImplV1 implements FileService{

	/*
	 * 편의상 파일 서비스 implv1 을 fileservicev2에서 상속하였다.
	 * v1 과 v2는 fileService 인터페이스를 implements 하고 있다.
	 * 결국 두 클래스는 모두 fileService 인터페이스의 자손이다.
	 * v1에서 구현된 코드를 v2에서 확장(일부 변경)하여 사용하고자 한다.
	 * 이때 v1 과 v2는 모두 uploadPath 변수를 사용해야한다.
	 * 이럴 경우 변수를 private 으로 선언해버리면 v2에서 다시 생성자를 통하여 uploadpath 변수를 주입 받아야한다.
	 * 상속을 해 주려는 클래스와 상속을 받는 클래스에서 공통으로 사용하는 변수가 잇을 경우 이 변수는 protectied로 선언해야한다.
	 * 
	 * 또한 유의해야한 것은 
	 * 생성자는 상속 되지 않는다.
	 */
	protected final String upLoadPath;
	
	
	public FileServiceImplV1(String upLoadPath) {
		this.upLoadPath = upLoadPath;
		log.debug("업로드폴더 {}",this.upLoadPath);
	}

	@Override
	public String fileUp(MultipartFile file) throws Exception {
		// TODO Auto-generated method stub
		
		String fileName = file.getOriginalFilename();
		if(fileName.isBlank()) {
			return null;
		}
		File path = new File(upLoadPath);
		if(!path.exists()) {
			path.mkdirs();
			/*
			 * 폴더를 생성하는 매서드
			 * 한개의 폴더만 생성하기(앱ㅗㅠㄹㄷ
			 */
		}
		
		String uuid = UUID.randomUUID().toString();
		fileName = String.format("%s-%s", uuid, fileName);
		File upload = new File(upLoadPath, fileName);
		
		//multipart 클래스에 정의 된 파일 전송매소드
		file.transferTo(upload);
		
		//DB에 파일 이름을 저장하기 위해서 변경된 파일이름을 return 하기
		return fileName;
	}

	@Override
	public List<ImageVO> filesUp(MultipartHttpServletRequest files) throws Exception {
		// TODO Auto-generated method stub
		
		/*
		 * view의 form input[type='file'] tag 의 name파일속성을 통하여 파일 내용 수정
		 */
		List<MultipartFile> fileList= files.getFiles("files");
		List<ImageVO> resultFiles = new ArrayList<>();
		for(MultipartFile file : fileList) {
			String resultName = this.fileUp(file);
			String originName = file.getOriginalFilename();
			ImageVO vo = ImageVO.builder().i_up_image(resultName)
											.i_origin_image(originName)
											.build();
			resultFiles.add(vo);
			
			
		}
		
		return resultFiles;
	}

}
