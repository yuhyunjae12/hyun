package com.spring.edu.dao.Impl;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.edu.dao.UsersDao;
import com.spring.edu.vo.UsersVo;
import com.spring.edu.vo.form.UsersForm;
import com.spring.edu.vo.form.UsersLogin;

@Repository
public class UsersDaoImpl implements UsersDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String nameSpace = "user.";

	
	@Override
	public int usersInsert(UsersForm usersVo) {
		int usersInsert = sqlSession.insert(nameSpace + "UsersInsert", usersVo);
		return usersInsert;
	}


	@Override
	public List<UsersVo> usersList() {
		List<UsersVo> res =sqlSession.selectList(nameSpace+"UsersList");
		return res;
	}


	@Override
	public UsersVo login(UsersLogin usersVo) {
		UsersVo res = sqlSession.selectOne(nameSpace+"UsersLogin", usersVo);
		return res;
	}


	@Override
	public int LoginCheck(UsersLogin usersVo) {
		int res =sqlSession.selectOne(nameSpace+"UserCheck", usersVo);
		return res;
	}
	
	

}
