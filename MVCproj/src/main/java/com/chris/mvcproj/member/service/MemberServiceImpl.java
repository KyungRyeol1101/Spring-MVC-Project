package com.chris.mvcproj.member.service;

import java.util.List;

import javax.inject.Inject;
 
import org.springframework.stereotype.Service;
 
import com.chris.mvcproj.member.model.dao.MemberDAOImpl;
import com.chris.mvcproj.member.model.dto.MemberVO;
 
// ���� Ŭ������ ���������� �����ϴ� service bean���� ���
@Service
public class MemberServiceImpl implements MemberService {
    
	// MemberDAOImpl ��ü�� ���������� �����Ͽ� ���Խ�Ŵ
    @Inject
    MemberDAOImpl memberDao;
    
    // 01. ��ü ȸ�� ��� ��ȸ
    @Override
    public List<MemberVO> memberList() {
        return memberDao.memberList();
    }
    
    // 02. ȸ�� ���
    @Override
    public void insertMember(MemberVO vo) {
        memberDao.insertMember(vo);
    }
    // 03. ȸ�� ���� �� ��ȸ 
    @Override
    public MemberVO viewMember(String userId) {
        return memberDao.viewMember(userId);
    }
    // 04. ȸ�� ���� ���� ó��
    @Override
    public void deleteMember(String userId) {
        memberDao.deleteMember(userId);
    }
    // 05. ȸ�� ���� ���� ó��
    @Override
    public void updateMember(MemberVO vo) {
        memberDao.updateMember(vo);
    }
    // 06. ȸ�� ���� ���� �� ������ ���� ��й�ȣ üũ
    @Override
    public boolean checkPw(String userId, String userPw) {
        return memberDao.checkPw(userId, userPw);
    }
}
 