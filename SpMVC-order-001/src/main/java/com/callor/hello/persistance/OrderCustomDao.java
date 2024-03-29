package com.callor.hello.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.hello.sql.TableSQL;

public interface OrderCustomDao {

//	@Select(TableSQL.ORDER_CUSTOM)
	public List<OrderCustomDao> selectAll();
}
