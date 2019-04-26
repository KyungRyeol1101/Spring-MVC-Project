package com.chris.mvcprojsecond.service.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.chris.mvcprojsecond.model.board.dao.BoardDAO;
import com.chris.mvcprojsecond.model.board.dto.BoardVO;

public interface BoardService {
	// 01. �Խñ� �ۼ�
	public void create(BoardVO vo) throws Exception;
	// 02. �Խñ� �󼼺���
	public BoardVO read(int bno) throws Exception;
	// 03. �Խñ� ����
	public void update(BoardVO vo) throws Exception;
	// 04. �Խñ� ����
	public void delete(int bno) throws Exception;
	// 05. �Խñ� ��ü ���
	public List<BoardVO> listAll(int start, int end, String searchOption, String keyword) throws Exception;
	// 06. �Խñ� ��ȸ
	public void increaseViewcnt(int bno, HttpSession session) throws Exception;
	// 07. �Խñ� ���ڵ� ����
	public int countArticle(String searchOption, String keyword) throws Exception;
	// 08. �Խñ� ÷������ ���
	public List<String> getAttach(int bno);
	// 09. �Խñ� ÷������ ����
	public void deleteFile(String fullname);
}