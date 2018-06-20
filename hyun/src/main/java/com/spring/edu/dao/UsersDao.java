package com.spring.edu.dao;


import java.util.List;
import java.util.Map;

import com.spring.edu.vo.UsersVo;
import com.spring.edu.vo.form.UsersForm;
import com.spring.edu.vo.form.UsersLogin;

public interface UsersDao {
	
	int usersInsert(UsersForm usersVo);
	List<UsersVo> usersList();
	UsersVo login(UsersLogin usersVo);
	int LoginCheck(UsersLogin usersVo);
	int UdundantInspection(Map<String,String> map);
}
