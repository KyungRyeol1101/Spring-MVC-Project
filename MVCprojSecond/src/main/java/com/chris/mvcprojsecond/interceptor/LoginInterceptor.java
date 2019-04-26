package com.chris.mvcprojsecond.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// ���� ��ü ����
		HttpSession session = request.getSession();
		// ���ǿ� id�� null�̸�
		if(session.getAttribute("userId") == null) {
			// �α��� �������� �̵�
			response.sendRedirect(request.getContextPath()+"/member/login.do?msg=nologin");
			// ��Ʈ�ѷ��� �������� �ʴ´�.(��û�������� �̵����� �ʴ´�)
			return false;
		// null�� �ƴϸ�
		} else {
			// ��Ʈ�ѷ��� ����(��û�������� �̵��Ѵ�.)
			return true;
		}
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
}