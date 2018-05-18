package com.spring.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.spring.edu.service.ProductService;
import com.spring.edu.utill.ProductExcelDownload;
import com.spring.edu.vo.ProductVo;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	@RequestMapping(value="/admin/main")
	public ModelAndView adminMain(ModelAndView modelAndView) {
		modelAndView.setViewName("/admin/main");
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/product")
	public ModelAndView adminProduct(ModelAndView modelAndView) {
		List<ProductVo> list =service.productList();
		modelAndView.addObject("productList",list);
		modelAndView.setViewName("/admin/productList");
		return modelAndView;
	}
	@RequestMapping(value="/admin/productWrite")
	public ModelAndView productWrite(ModelAndView modelAndView) {
		modelAndView.setViewName("/admin/productWrite");
		return modelAndView;
	}
	
	@RequestMapping("/admin/product/productExcelDownload")
	public View productExcelDownload(Model model) {
		List<ProductVo> List = service.productList(); 
		model.addAttribute("List", List);
		
		return (View) new ProductExcelDownload();
	}
	
}
