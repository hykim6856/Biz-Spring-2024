package com.callor.hello.models;

import java.util.List;

import com.callor.hello.dao.UserDao;

public interface UserVO {

	public List<UserVO> selectAll();

}
