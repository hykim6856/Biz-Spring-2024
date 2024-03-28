package com.callor.hello.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.ProductVO;

public interface ProductDao {



	@Select("SELECT * FROM tbl_product")
	public List<ProductVO> selectAll();

	public void findByPK(String pk);

	public int insert(ProductVO productVO);

	public int update(ProductVO productVO);

	public int delete(String pk);
}
