package com.chris.mvcprojsecond.service.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
 
import org.springframework.stereotype.Service;
 
import com.chris.mvcprojsecond.model.member.dao.MemberDAO;
import com.chris.mvcprojsecond.model.member.dto.MemberVO;
 
@Service // ���� Ŭ������ ���������� �����ϴ� service bean���� ���
public class MemberServiceImpl implements MemberService {
    
    @Inject
    MemberDAO memberDao;
    
    // 01_01. ȸ�� �α���üũ
    @Override
    public boolean loginCheck(MemberVO vo, HttpSession session) {
        boolean result = memberDao.loginCheck(vo);
        if (result) { // true�� ��� ���ǿ� ���
            MemberVO vo2 = viewMember(vo);
            // ���� ���� ���
            session.setAttribute("userId", vo2.getUserId());
            session.setAttribute("userName", vo2.getUserName());
        } 
        return result;
    }
    // 01_02. ȸ�� �α��� ����
    @Override
    public MemberVO viewMember(MemberVO vo) {
        return memberDao.viewMember(vo);
    }
    // 02. ȸ�� �α׾ƿ�
    @Override
    public void logout(HttpSession session) {
        // ���� ���� ���� ����
        // session.removeAttribute("userId");
        // ���� ������ �ʱ�ȭ ��Ŵ
        session.invalidate();
    }
}