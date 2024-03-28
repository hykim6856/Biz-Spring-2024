package com.callor.hello.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.OrdersVO;
/**
 * 
 * DBMS 연동 프로젝트에서 필수적으로 
 * 구현이 필요한 5가지 method 구조
 *
 */
public interface OrdersDao {

	// table 의 모든 데이터들을 SELECT 하기
	// 이 함수의 return type이 무엇일까.

	@Select("SELECT * FROM tbl_orders")
	public List<OrdersVO> selectAll();

	public void findByPK(String pk);

	public int insert(OrdersVO orderVO);

	public int update(OrdersVO orderVO);

	public int delete(String pk);
}
