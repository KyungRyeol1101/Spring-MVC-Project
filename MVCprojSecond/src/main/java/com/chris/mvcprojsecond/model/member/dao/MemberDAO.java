package com.chris.mvcprojsecond.model.member.dao;

import javax.servlet.http.HttpSession;
import com.chris.mvcprojsecond.model.member.dto.MemberVO;
 
public interface MemberDAO {
    // 01_01. ȸ�� �α��� üũ
    public boolean loginCheck(MemberVO vo);
    // 01_02. ȸ�� �α��� ����
    public MemberVO viewMember(MemberVO vo);
    // 02. ȸ�� �α׾ƿ�
    public void logout(HttpSession session);
}
