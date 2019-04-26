package com.chris.mvcprojsecond.model.member.dao;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
 
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
 
import com.chris.mvcprojsecond.model.member.dto.MemberVO;
 
@Repository // ���� Ŭ������ ���������� �����ϴ� dao bean���� ���
public class MemberDAOImpl implements MemberDAO {
    // SqlSession ��ü�� �����ο��� �����Ͽ� ����
    // �������� ����(Dependency Injection), ������ ����
    @Inject
    SqlSession sqlSession; // mybatis ���� ��ü
    
    // 01_01. ȸ�� �α���üũ
    @Override
    public boolean loginCheck(MemberVO vo) {
        String name = sqlSession.selectOne("member.loginCheck", vo);
        return (name == null) ? false : true;
    }
    // 01_02. ȸ�� �α��� ����
    @Override
    public MemberVO viewMember(MemberVO vo) {
        return sqlSession.selectOne("member.viewMember", vo);
    }
    // 02. ȸ�� �α׾ƿ�
    @Override
    public void logout(HttpSession sessin) {
    }
}