package com.chris.mvcprojsecond.service.admin;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chris.mvcprojsecond.model.admin.AdminDAO;
import com.chris.mvcprojsecond.model.member.dto.MemberVO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Inject
	AdminDAO adminDao;
	
	// ������ �α���üũ
	@Override
	public String loginCheck(MemberVO vo) {
		return adminDao.loginCheck(vo);
	}
}
