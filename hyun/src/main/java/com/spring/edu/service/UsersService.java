package com.spring.edu.service;

import java.util.List;

import com.spring.edu.vo.UsersVo;
import com.spring.edu.vo.form.UsersForm;
import com.spring.edu.vo.form.UsersLogin;


public interface UsersService {

	int usersInsert(UsersForm usersVo);
	List<UsersVo> usersList();
	UsersVo login(UsersLogin usersVo);
	int LoginCheck(UsersLogin usersVo);
	int UdundantInspection(String column, String val);
}
