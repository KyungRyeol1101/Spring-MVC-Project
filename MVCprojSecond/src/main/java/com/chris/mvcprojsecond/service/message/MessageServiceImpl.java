package com.chris.mvcprojsecond.service.message;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chris.mvcprojsecond.model.message.dao.MessageDAO;
import com.chris.mvcprojsecond.model.message.dao.PointDAO;
import com.chris.mvcprojsecond.model.message.dto.MessageVO;


@Service
public class MessageServiceImpl implements MessageService {
	
	@Inject
	MessageDAO messageDao;
	
	@Inject
	PointDAO pointDao;
	
	// �޽��� �ۼ�(DB����, ����Ʈ����)
	@Transactional // Ʈ�����ó�� ��� �޼���
	@Override
	public void addMessage(MessageVO vo) {
		// ������� - �α� Ȯ��
		
		// �ٽɾ��� - �޽��� ����, ȸ�� ����Ʈ ����
		// �޽����� ���̺� ����
		messageDao.create(vo);
		// �޽����� �߼��� ȸ������ 10����Ʈ �߰�
		pointDao.updatePoint(vo.getSender(), 10);

	}
	// �޽��� ����
	@Override
	public MessageVO readMessage(String userid, int mid) {
		
		return null;
	}
}