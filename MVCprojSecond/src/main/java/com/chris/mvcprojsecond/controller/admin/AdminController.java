package com.chris.mvcprojsecond.controller.admin;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chris.mvcprojsecond.model.member.dto.MemberVO;
import com.chris.mvcprojsecond.service.admin.AdminService;

@Controller
@RequestMapping("admin/*")
public class AdminController {
	
	@Inject
	AdminService adminService;
	
	// 1. ������  �α��������� ����
	@RequestMapping("login.do")
	public String login(){
		return "admin/adminLogin";
	}
	// 2. ������  �α��� üũ 
	@RequestMapping("loginCheck.do")
	public ModelAndView loginCheck(HttpSession session, MemberVO vo, ModelAndView mav){
		String name = adminService.loginCheck(vo);
		// �α��� ����
		if(name != null) {
			session.setAttribute("adminId", vo.getUserId());
			session.setAttribute("userId", vo.getUserId());
			session.setAttribute("adminName", name);
			session.setAttribute("userName", name);
			mav.setViewName("admin/adminHome"); // ������ ������ �̵�
			mav.addObject("msg", "success");
		// �α��� ����
		} else { 
			mav.setViewName("admin/adminLogin"); // �α��� ������ �̵�
			mav.addObject("msg", "failure");
		}
		return mav;
	}
	
	// 3. ������ �α׾ƿ�
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session){
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/adminLogin");
		mav.addObject("msg", "logout");
		return mav;
	}
}
