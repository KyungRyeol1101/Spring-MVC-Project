package com.chris.mvcprojsecond.model.board.dao;

import java.util.List;

import com.chris.mvcprojsecond.model.board.dto.BoardVO;
 
public interface BoardDAO {
	// 01. �Խñ� �ۼ�
		public void create(BoardVO vo) throws Exception;
		// 02. �Խñ� �󼼺���
		public BoardVO read(int bno) throws Exception;
		// 03. �Խñ� ����
		public void update(BoardVO vo) throws Exception;
		// 04. �Խñ� ����
		public void delete(int bno) throws Exception;
		// 05. �Խñ� ��ü ��� ==> �˻��ɼ�, Ű���� �Ű����� �߰�
		public List<BoardVO> listAll(int start, int end, String searchOption, String keyword) throws Exception;
		// 06. �Խñ� ��ȸ ����
		public void increaseViewcnt(int bno) throws Exception;
		// 07. �Խñ� ���ڵ� ���� �޼��� �߰�
		public int countArticle(String searchOption, String keyword) throws Exception;
		// 08. �Խù� ÷������ �߰�
		public void addAttach(String fullName);
		// 09. �Խù� ÷������ ���
		public List<String> getAttach(int bno);
		// 10. �Խñ� ÷������ ����ó��
		public void deleteFile(String fullname);
		// 11. �Խñ� ÷������ ������Ʈó��
		public void updateAttach(String fullName, int bno);
	}