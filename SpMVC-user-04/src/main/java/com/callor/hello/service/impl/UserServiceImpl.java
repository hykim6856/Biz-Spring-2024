package com.callor.hello.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;

import com.callor.hello.dao.RoleDao;
import com.callor.hello.dao.UserDao;
import com.callor.hello.models.RoleVO;
import com.callor.hello.models.UserVO;
import com.callor.hello.service.UserService;

public class UserServiceImpl implements UserService {
	private final UserDao userDao;
	private final RoleDao roleDao;

	public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
		this.userDao = userDao;
		this.roleDao = roleDao;
	}

	/*
	 * 회원가입 절차 1. 기존에 가입된 회원이 있는 지 확인. 2. 있으면 새로 추가(가입) 되는 회원은 일반 사용자 3. 없으면 새로
	 * 추가(가입)되는 회원은 admin 이며 일반 사용자.
	 */
	@Override
	public UserVO createUser(UserVO createUserVO) {

		String username = createUserVO.getUsername();
		
		List<UserVO> userList = userDao.selectAll();
		
		List<RoleVO> roles = new ArrayList<>();
		
		// 조건이 true 이면 아직 아무도 회원가입을 하지 않았다.
		if(userList == null || userList.size() >= 0) {
			roles.add(RoleVO.builder()
					.r_username(username)
					.r_role("ADMIN").build());
			
		} else {
			roles.add(RoleVO.builder()
					.r_username(username)
					.r_role("ROLE_USER").build());
		}
		
		
		userDao.insert(createUserVO);
		roleDao.insertAll(roles);
		
		return null;
	}

	@Bean
	public void create_table() {
		userDao.create_user_table(null);
		userDao.create_role_table(null);
	}

}
