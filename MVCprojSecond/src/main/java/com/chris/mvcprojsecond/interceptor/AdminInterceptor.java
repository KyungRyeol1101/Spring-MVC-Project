package com.chris.mvcprojsecond.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// ���ͼ��� : ��û ���Ŀ� �ڵ����� ó��(����)�Ǵ� Ŭ����
// preHandle() ==> return true 	==> write.do ==> postHandle()
// 			   ==> return false	==> login.do
public class AdminInterceptor extends HandlerInterceptorAdapter{
	// ��û �� ó��
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// ���ǰ�ü ����
		HttpSession session = request.getSession();
		// session�� ������id�� null�̸�
		if(session.getAttribute("adminId") == null){
			response.sendRedirect(request.getContextPath()+"/member/login.do?msg=nologin"); //�Ϲݻ���� �α���ȭ������ �����̷�Ʈ
			return false; // ��û ���� X
		// null�� �ƴϸ�
		} else {
			return true; // ��û ���� O
		}
	}
	// ��û ó�� �� 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
}