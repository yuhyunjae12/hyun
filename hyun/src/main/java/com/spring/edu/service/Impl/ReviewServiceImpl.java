package com.spring.edu.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.edu.dao.ReviewDao;
import com.spring.edu.service.ReviewService;
import com.spring.edu.vo.ReviewVo;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDao dao;
	
	@Override
	public List<ReviewVo> listAll()throws Exception {
		return dao.listAll();	
	}

	@Override
	public void regist(ReviewVo vo) throws Exception {
		dao.create(vo);
	}
	
	
	
}