package com.spring.board.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.board.member.dao.MemberDAO;
import com.spring.board.member.dto.MemberDTO;
import com.spring.board.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService memservice;
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public ModelAndView joinmem(MemberDTO memdto, HttpSession sess) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/board");
		
		
		memservice.joinMember(memdto);
		sess.setAttribute("MemberDTO", memdto);	
		
		return mav;
	}
	
	@RequestMapping(value="/joinForm", method=RequestMethod.GET)
	public ModelAndView joinForm() throws Exception{
		ModelAndView mav = new ModelAndView("/join/memberjoin");
		return mav;
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginmem(MemberDTO memdto, HttpSession sess, @RequestParam("id") String id, @RequestParam("pw") String pw) throws Exception{
		ModelAndView mav = new ModelAndView("redirect:/board");
		MemberDTO logdto = new MemberDTO(); 
		logdto.setId(id); 
		logdto.setPw(pw);
		
		Object iddto =  sess.getId();
		
		if(iddto !=null && iddto.toString() != null) {
			
			sess.setAttribute("isLogon", true);
			sess.setAttribute("MemberDTO", memdto);
		}
		
		if(iddto == null || iddto.toString() == "") {
			mav.addObject("result", "loginFailed");
			mav.setViewName("/login/login");
		}else {
			mav.setViewName("/main/boardall");
		}
		
		memservice.loginMember(memdto);	
		return mav;
	}
	

	
	@RequestMapping(value="/loginForm", method=RequestMethod.GET)
	public ModelAndView loginForm() throws Exception{
		ModelAndView mav = new ModelAndView("/login/login");
		return mav;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public ModelAndView logoutmem(HttpSession sess) throws Exception{	
		ModelAndView mav = new ModelAndView("redirect:/board");
		sess.setAttribute("isLogon", false);
		sess.removeAttribute("MemberDTO");
		return mav;
	}
}
