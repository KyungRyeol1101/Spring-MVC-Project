package com.chris.mvcprojsecond.model.admin;

import com.chris.mvcprojsecond.model.member.dto.MemberVO;

public interface AdminDAO {
	// ������ �α���üũ
	public String loginCheck(MemberVO vo);
}