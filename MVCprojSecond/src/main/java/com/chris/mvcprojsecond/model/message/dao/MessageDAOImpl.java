package com.chris.mvcprojsecond.model.message.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.chris.mvcprojsecond.model.message.dto.MessageVO;

@Repository
public class MessageDAOImpl implements MessageDAO {
	@Inject
	SqlSession sqlSession;
	
	// �޽��� �ۼ�
	@Override
	public void create(MessageVO vo) {
		sqlSession.insert("message.create", vo);
	}
	// �޽��� ����
	@Override
	public MessageVO readMessage(int mid) {
		
		return null;
	}
	// �޽��� �����ð� ����
	@Override
	public void updateMessage(int mid) {
	
	}
}
