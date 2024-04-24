package com.callor.gallery.dao;

import java.util.List;

import com.callor.gallery.models.BBsVO;

/*
 * 제네릭 인터페이스 상속하여 다오 인터페이스 만들기
 * 제네릭다오에 선언된 5가지 crud 메소드는 그대로 상속
 * 이때 리턴 타입과 pk매개 변수의 type을 필요한 요소로 대체한다.
 * 대체 할대 geneic type 에 명시해준다.
 * 그 외 필요한 메소드가 있으면 별도로 선언하여 사용 할 수 있다.
 * 결국 bbsdao 에는 총 8가지의 method가 선언되는 것과 같다.
 */
public interface BBsDao extends GenericDao<BBsVO, String> {
	
	public List<BBsVO> findByDate(String sdate, String edate);
	public List<BBsVO> findBySubject(String subject);
	public List<BBsVO> findByContent(String content);

//	public List<BBsVO> selectAll();
//	public BBsVO findById(String pk);
//	
//	public int insert(BBsVO vo);
//	public int update(BBsVO vo);
//	public int delete(String pk);
}
