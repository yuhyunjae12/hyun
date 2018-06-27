package com.spring.edu.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.edu.service.UsersService;
import com.spring.edu.utill.Criteria;
import com.spring.edu.utill.Paging;
import com.spring.edu.vo.UsersVo;
import com.spring.edu.vo.form.UsersForm;
import com.spring.edu.vo.form.UsersLogin;

/**
  * @FileName : UsersController.java
  * @Project : hyun
  * @Date : 2018. 6. 20. 
  * @작성자 : 유현재
  * @변경이력 :
  * @프로그램 설명 : 회원 컨트롤러
  */
@Controller
public class UsersController {
	
	@Autowired
	private UsersService service;
	
	/**
	  * @Method Name : usersInsert
	  * @작성일 : 2018. 6. 20.
	  * @작성자 : 유현재
	  * @변경이력 : 
	  * @Method 설명 : 회원가입 폼
	  * @param modelAndView
	  * @return
	  */
	@RequestMapping(value="/users/usersInsert")
	public ModelAndView usersInsert(ModelAndView modelAndView) {
		modelAndView.setViewName("/users/usersInsert");
		return modelAndView;
	}
	
	/**
	  * @Method Name : usersInsertAfter
	  * @작성일 : 2018. 6. 20.
	  * @작성자 : 유현재
	  * @변경이력 : 
	  * @Method 설명 : 회원가입
	  * @param usersVo
	  * @param result
	  * @return
	  */
	@RequestMapping(value="/users/insertAfter",method=RequestMethod.POST)
	public ModelAndView usersInsertAfter(@ModelAttribute @Valid UsersForm usersVo, BindingResult result) {
		if(result.hasErrors()) {
			 ModelAndView modelAndView = new ModelAndView();
			 modelAndView.setViewName("/users/usersInsert");
			 return modelAndView;
		}
		service.usersInsert(usersVo);
		return new ModelAndView("redirect:/");
		
	}
	
	/**
	  * @Method Name : usersAdminList
	  * @작성일 : 2018. 6. 20.
	  * @작성자 : 유현재
	  * @변경이력 : 
	  * @Method 설명 : 회원 리스트
	  * @param modelAndView
	  * @return
	  */
	@RequestMapping(value="/admin/userAdminList")
	public ModelAndView usersAdminList(@ModelAttribute("cri")Criteria cri, ModelAndView modelAndView) {
		modelAndView.addObject("userList", service.usersList(cri));
		Paging paging=new Paging();
		paging.setCri(cri);
		paging.setTotalCount(service.usersCount());
		modelAndView.addObject("paging", paging);
		modelAndView.setViewName("admin/userAdminList.admin");
		return modelAndView;
	}
	
	
    /**
      * @Method Name : UsersLogin
      * @작성일 : 2018. 6. 20.
      * @작성자 : 유현재
      * @변경이력 : 
      * @Method 설명 : 로그인
      * @param session
      * @param usersVo
      * @return
      */
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
    
    /**
      * @Method Name : logout
      * @작성일 : 2018. 6. 20.
      * @작성자 : 유현재
      * @변경이력 : 로그아웃
      * @Method 설명 :
      * @param session
      * @return
      */
    @RequestMapping(value="/users/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 전체를 날려버림
//      session.removeAttribute("login"); // 하나씩 하려면 이렇게 해도 됨.
        return "redirect:/"; 
    }
    
    @RequestMapping(value="/users/juso")
    public String logout() {
        return "/users/jusoPopup"; 
    }
    
	@RequestMapping(value = "/users/UdundantInspection")
	@ResponseBody
	public int UserUdundantInspection(Model model, @RequestParam("column") String column,
			@RequestParam("val") String val, HttpServletResponse response) {
		System.out.println(val);
		int urNo = service.UdundantInspection(column, val);
		return urNo;
	}
}
