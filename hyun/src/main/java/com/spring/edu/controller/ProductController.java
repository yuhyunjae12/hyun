package com.spring.edu.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.spring.edu.service.ProductService;
import com.spring.edu.utill.ProductExcelDownload;
import com.spring.edu.vo.ProductVo;
import com.spring.edu.vo.form.productForm;

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
	public ModelAndView productList(ModelAndView modelAndView) {
		List<ProductVo> list =service.productList();
		modelAndView.addObject("productList",list);
		modelAndView.setViewName("/admin/productList");
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/productDetail")
	public ModelAndView productDetail(ModelAndView modelAndView, @RequestParam("pdNo") int pdNo) {
		ProductVo detail = service.productDetail(pdNo);
		modelAndView.addObject("productDetail",detail);
		modelAndView.setViewName("/admin/productDetail");
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/productUpdate")
	public ModelAndView productUpdate(ModelAndView modelAndView, @RequestParam("pdNo") int pdNo) {
		ProductVo detail = service.productDetail(pdNo);
		modelAndView.addObject("productDetail",detail);
		modelAndView.setViewName("/admin/productUpdate");
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin/productUpdateAfter", method=RequestMethod.POST)
	public ModelAndView productUpdateAfter(@RequestParam("productImg") MultipartFile file
	        ,HttpServletRequest request
	        ,@ModelAttribute @Valid productForm productVo, BindingResult result) throws Exception {
	     
		if(result.hasErrors()) {
			 ModelAndView modelAndView = new ModelAndView();
			 modelAndView.setViewName("/admin/productUpdate?pdNo="+productVo.getPdNo());
			 return modelAndView;
		}
	     
	     File f = new File("C:\\Users\\hyun\\uploads\\"+file.getOriginalFilename());
	     file.transferTo(f);
	     
	     productVo.setPdImg(file.getOriginalFilename().toString());
	     service.productInsert(productVo);
	    return new ModelAndView("redirect:/admin/product");
	}
	@RequestMapping(value="/admin/productWrite")
	public ModelAndView productWrite(ModelAndView modelAndView) {
		modelAndView.setViewName("/admin/productWrite");
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin/productWriterAfter", method=RequestMethod.POST)
	public ModelAndView productWrite(@RequestParam("productImg") MultipartFile file
	        ,HttpServletRequest request
	        ,@ModelAttribute @Valid productForm productVo, BindingResult result) throws Exception {
	     
		if(result.hasErrors()) {
			 ModelAndView modelAndView = new ModelAndView();
			 modelAndView.setViewName("/admin/productWrite");
			 return modelAndView;
		}
	     
	     File f = new File("C:\\Users\\hyun\\uploads\\"+file.getOriginalFilename());
	     file.transferTo(f);
	     
	     productVo.setPdImg(file.getOriginalFilename().toString());
	     service.productInsert(productVo);
	    return new ModelAndView("redirect:/admin/product");
	}
	
	@RequestMapping("/admin/product/productExcelDownload")
	public View productExcelDownload(Model model) {
		List<ProductVo> List = service.productList(); 
		model.addAttribute("List", List);
		
		return (View) new ProductExcelDownload();
	}
	
}
