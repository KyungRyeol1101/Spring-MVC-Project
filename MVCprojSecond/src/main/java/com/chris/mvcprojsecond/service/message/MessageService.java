package com.chris.mvcprojsecond.service.message;

import com.chris.mvcprojsecond.model.message.dto.MessageVO;

public interface MessageService {
	// �޽��� �ۼ�(DB����, ����Ʈ����)
	public void addMessage(MessageVO vo);
	// �޽��� ����
	public MessageVO readMessage(String userid, int mid);
}