package com.callor.gallery.service.impl;

import org.springframework.stereotype.Service;

import com.callor.gallery.config.QualifierConfig;

/*
 * 프로젝트에서 한개의 interface 를 implements 하여 다수의 클래스를 정의 하는 경ㅇ우가 잇다.
 * 이럴때 사용하는 곳에서 interface 를 사용하여 객체를선언하고 
 * 생성자나, setter 등을 통하여 객체(bean)를 주입받는다.
 * 이럴때 한개의 interface를 implement 한 객체가 두개이상인 경우 
 * spring의 dI 는 어떤 클래스를 주입해야하는지 알수 없다.
 * spring DI에게 어떤 클래스(객체)를 주입해야할 지 알려주기 위하여
 * service annotation에 이름을 부여하고
 * 주입받는 곳에서는 Quelifier 를 사용하여 명시적으로 어떤 클래스(객체)를 주입받을지 선언해주어야 한다.
 */
@Service(QualifierConfig.SERVICE.FILE_SERVICE_V2)
public class FileServiceImplV2 extends FileServiceImplV1{

	/*
	 * v1에서 생성자를 통하여 uploadpath 변수를 주입받고 있다.
	 * uploadpath변수는 v1과 v2에서 공통으로 사용해야하는 변수이다.
	 * 이럴 경우 상속받은 클래스에서 반드시 생성자를 구현하고 
	 * 생성자를 통하여 uploadpath 변수를 주입받아야한다.
	 */
	public FileServiceImplV2(String upLoadPath) {
		super(upLoadPath);
		// TODO Auto-generated constructor stub
	}

}
