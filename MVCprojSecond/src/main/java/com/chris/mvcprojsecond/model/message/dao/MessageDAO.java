package com.chris.mvcprojsecond.model.message.dao;

import com.chris.mvcprojsecond.model.message.dto.MessageVO;

public interface MessageDAO {
	// �޽��� �ۼ�
	public void create(MessageVO vo);
	// �޽��� ����
	public MessageVO readMessage(int mid);
	// �޽��� �����ð� ���� 
	public void updateMessage(int mid);
}