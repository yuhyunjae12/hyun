package com.spring.edu.service;

import java.util.List;

import com.spring.edu.vo.UsersVo;
import com.spring.edu.vo.form.UsersForm;


public interface UsersService {

	int usersInsert(UsersForm usersVo);
	List<UsersVo> userList();
}
