package com.callor.gallery.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.callor.gallery.models.ImageVO;

public interface ImagesDao extends GenericDao<ImageVO, String> {

//	public	void create_table(String string);

	/*
	 * Dao 의 method 에서  mapper 로 전달하는 매개변수가 1개만 있는경우는
	 * 이름이 중요하지 않다. 매개변수 이름이 pk 라고 했을때
	 * mapper 에서는 #{id}처럼 사용해도 아무런 문제가 없다.
	 * 
	 * 그런데 Dao 에서 mapper로 전달하는 매개변수가 2개 이상일 경우는 이름이 매우 중요하다. 때 문에 @param()이라는 
	 * 어노테이션을 사용하여 각각의 매개변수에 이름을 지정하고, 매퍼에서는 그 이름을 사용해야한다.
	 */
	
	public	int inserts(
			
		@Param("g_id")	String i_gid,
		@Param("images") List<ImageVO> resultNames);
	


	
}
