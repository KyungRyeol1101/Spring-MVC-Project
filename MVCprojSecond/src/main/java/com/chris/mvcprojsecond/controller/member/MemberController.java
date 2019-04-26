package com.chris.mvcprojsecond.controller.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
import com.chris.mvcprojsecond.model.member.dto.MemberVO;
import com.chris.mvcprojsecond.service.member.MemberService;
 
 
@Controller // ���� Ŭ������ ���������� �����ϴ� ��Ʈ�ѷ� bean���� ����
@RequestMapping("/member/*") // �������� /member/�� ���
public class MemberController {
    // �α��� ���� ����
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
    
    @Inject
    MemberService memberService;
    
    // 01. �α��� ȭ�� 
    @RequestMapping("login.do")
    public String login(){
        return "member/login";    // views/member/login.jsp�� ������
    }
    
    // 02. �α��� ó��
    @RequestMapping("loginCheck.do")
    public ModelAndView loginCheck(@ModelAttribute MemberVO vo, HttpSession session){
        boolean result = memberService.loginCheck(vo, session);
        ModelAndView mav = new ModelAndView();
        if (result == true) { // �α��� ����
            // main.jsp�� �̵�
            mav.setViewName("home");
            mav.addObject("msg", "success");
        } else {    // �α��� ����
            // login.jsp�� �̵�
            mav.setViewName("member/login");
            mav.addObject("msg", "failure");
        }
        return mav;
    }
    
    // 03. �α׾ƿ� ó��
    @RequestMapping("logout.do")
    public ModelAndView logout(HttpSession session){
        memberService.logout(session);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("member/login");
        mav.addObject("msg", "logout");
        return mav;
    }
}