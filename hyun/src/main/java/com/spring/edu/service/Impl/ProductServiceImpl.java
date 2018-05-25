package com.spring.edu.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.edu.dao.ProductDao;
import com.spring.edu.service.ProductService;
import com.spring.edu.vo.ProductVo;
import com.spring.edu.vo.form.productForm;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;
	
	@Override
	public List<ProductVo> productList() {
		return dao.productList();
	}

	@Override
	public int productInsert(productForm productVo) {
		return dao.productInsert(productVo);
	}

	@Override
	public ProductVo productDetail(int pdNo) {
		return dao.productDetail(pdNo);
	}
	
	

}
