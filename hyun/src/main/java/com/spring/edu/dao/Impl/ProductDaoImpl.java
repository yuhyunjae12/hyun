package com.spring.edu.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.edu.dao.ProductDao;
import com.spring.edu.vo.ProductVo;
import com.spring.edu.vo.form.productForm;
@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SqlSessionTemplate session;
	private String namespace ="product.";
	
	@Override
	public List<ProductVo> productList() {
		List<ProductVo> list = session.selectList(namespace+"productList");
		return list;
	}

	@Override
	public int productInsert(productForm productVo) {
		int res = session.insert(namespace+"productInsert", productVo);
		return res;
	}

	@Override
	public ProductVo productDetail(int pdNo) {
		ProductVo res = session.selectOne(namespace+"productDetail", pdNo);
		return res;
	}
	
	
	

}
