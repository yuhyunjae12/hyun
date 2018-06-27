package com.spring.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.edu.service.ProductService;
import com.spring.edu.utill.Criteria;

@Controller
public class MainController {
	
	@Autowired
	private ProductService service;

	@RequestMapping("/")
	public ModelAndView boardMain(@ModelAttribute("cri")Criteria cri, ModelAndView modelAndView) {
		cri.setPerPageNum(8);
		modelAndView.addObject("productList", service.shopList(cri));
		modelAndView.setViewName("/home");
		return modelAndView;
	}

}
