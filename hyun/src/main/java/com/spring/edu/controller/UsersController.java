package com.spring.edu.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.edu.service.UsersService;
import com.spring.edu.vo.UsersVo;
import com.spring.edu.vo.form.UsersForm;

@Controller
public class UsersController {
	
//	@RequestMapping("/")
//	public ModelAndView main(Model model, ModelAndView modelAndView) {
//		System.out.println(">>>>>>>>>>>>>>>>>>>>>메인페이지접속");
//		modelAndView.setViewName("index");
//		
//		return modelAndView;
//	}
	@Autowired
	private UsersService service;
	
	@RequestMapping(value="/users/usersInsert")
	public ModelAndView usersInsert(ModelAndView modelAndView) {
		modelAndView.setViewName("/users/usersInsert");
		return modelAndView;
	}
	
	@RequestMapping(value="/users/insertAfter",method=RequestMethod.POST)
	public ModelAndView usersInsertAfter(@ModelAttribute @Valid UsersForm usersVo, BindingResult result) {
		if(result.hasErrors()) {
			 ModelAndView modelAndView = new ModelAndView();
			 modelAndView.setViewName("/users/usersInsert");
			 return modelAndView;
		}
		service.usersInsert(usersVo);
		return new ModelAndView("redirect:/users/usersInsert");
		
	}
	
	@RequestMapping(value="/admin/userAdminList")
	public ModelAndView usersAdminList(ModelAndView modelAndView) {
		List<UsersVo> list = service.userList();
		modelAndView.addObject("userList",list);
		modelAndView.setViewName("admin/userAdminList.admin");
		return modelAndView;
	}
	
}
