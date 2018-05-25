package com.spring.edu.service;

import java.util.List;

import com.spring.edu.vo.ProductVo;
import com.spring.edu.vo.form.productForm;

public interface ProductService {

	List<ProductVo> productList();
	int productInsert(productForm productVo);
	ProductVo productDetail(int pdNo);

}
