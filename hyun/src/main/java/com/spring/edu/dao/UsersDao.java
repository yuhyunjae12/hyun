package com.spring.edu.dao;


import java.util.List;

import com.spring.edu.vo.UsersVo;
import com.spring.edu.vo.form.UsersForm;

public interface UsersDao {
	
	int usersInsert(UsersForm usersVo);
	List<UsersVo> usersList();
}
