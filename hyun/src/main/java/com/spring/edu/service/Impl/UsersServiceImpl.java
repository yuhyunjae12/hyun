package com.spring.edu.service.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.edu.dao.Impl.UsersDaoImpl;
import com.spring.edu.service.UsersService;
import com.spring.edu.vo.UsersVo;
import com.spring.edu.vo.form.UsersForm;
import com.spring.edu.vo.form.UsersLogin;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDaoImpl dao;
	
	@Override
	public int usersInsert(UsersForm usersVo) {
		return dao.usersInsert(usersVo);
	}

	@Override
	public List<UsersVo> usersList() {
		return dao.usersList();
	}

	@Override
	public UsersVo login(UsersLogin usersVo) {
		return dao.login(usersVo);
	}

	@Override
	public int LoginCheck(UsersLogin usersVo) {
		return dao.LoginCheck(usersVo);
	}
	
	
	
}
