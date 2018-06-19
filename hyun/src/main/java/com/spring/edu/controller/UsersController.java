package com.spring.edu.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.edu.service.UsersService;
import com.spring.edu.vo.UsersVo;
import com.spring.edu.vo.form.UsersForm;
import com.spring.edu.vo.form.UsersLogin;

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
		List<UsersVo> list = service.usersList();
		modelAndView.addObject("userList",list);
		modelAndView.setViewName("admin/userAdminList.admin");
		return modelAndView;
	}
	
	
    @RequestMapping(value="/users/login",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Boolean> UsersLogin(HttpSession session, UsersLogin usersVo){
        if ( session.getAttribute("login") != null ){
            // 기존에 login이란 세션 값이 존재한다면
            session.removeAttribute("login"); // 기존값을 제거해 준다.
        }
        Map<String,Boolean> resMap=new HashMap<String,Boolean>();
        boolean UrYn = false;
        if(service.LoginCheck(usersVo) != 0) {
	        // 로그인이 성공하면 UsersVO 객체를 반환함.
	        UsersVo vo = service.login(usersVo);
	        if ( vo != null ){ // 로그인 성공
	            session.setAttribute("login", vo); // 세션에 login인이란 이름으로 UsersVO 객체를 저장해 놈.
	        }
	        
	        if(vo.getUrYn().equals("Y")){
	        	UrYn=true;
	        }
	        resMap.put("UrYn", UrYn);
        }else {
        	resMap.put("UrYn",false);
        }
         
        return resMap;
        
        
    }
    // 로그아웃 하는 부분
    @RequestMapping(value="/users/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 전체를 날려버림
//      session.removeAttribute("login"); // 하나씩 하려면 이렇게 해도 됨.
        return "redirect:/"; 
    }
	
}
