package com.callor.iolist.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.callor.iolist.models.IolistVO;

public interface IolistDao {

	@Select("SELECT * FROM tbl_iolist " + "ORDER BY io_seq")
	public List<IolistVO> selectAll();

	public int insert(IolistVO vo);

	@Select("SELECT * FROM tbl_iolist" + " WHERE io_seq = #{io_seq}")
	public IolistVO findById(String io_seq);

	public int update(IolistVO iolistVO);

	@Delete("DELETE FROM tbl_iolist WHERE io_seq = #{io_seq}")
	public int delete(String io_seq);

}
