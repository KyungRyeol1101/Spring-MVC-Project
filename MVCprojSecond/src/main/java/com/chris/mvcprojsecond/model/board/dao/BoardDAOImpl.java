package com.chris.mvcprojsecond.model.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
 
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
 
import com.chris.mvcprojsecond.model.board.dto.BoardVO;
 
@Repository    // ���� Ŭ������ dao bean���� ���
public class BoardDAOImpl implements BoardDAO {
	@Inject
	SqlSession sqlSession;
	// 01_01. �Խñ� �ۼ�
	@Override
	public void create(BoardVO vo) throws Exception {
		sqlSession.insert("board.insert", vo);
	}
	
	// 01_02 �Խù� ÷������ �߰�
	@Override
	public void addAttach(String fullName) {
		sqlSession.insert("board.addAttach", fullName);
	}
	
	// 02. �Խñ� �󼼺���
	@Override
	public BoardVO read(int bno) throws Exception {
		return sqlSession.selectOne("board.view", bno);
	}
	// 03. �Խñ� ����
	@Override
	public void update(BoardVO vo) throws Exception {
		sqlSession.update("board.updateArticle", vo);

	}
	// 04. �Խñ� ����
	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("board.deleteArticle",bno);

	}
	// 05. �Խñ� ��ü ���
	@Override
	public List<BoardVO> listAll(int start, int end, String searchOption, String keyword) throws Exception {
		// �˻��ɼ�, Ű���� �ʿ� ����
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		// BETWEEN #{start}, #{end}�� �Էµ� ��
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("board.listAll", map);
	}
	// 06. �Խñ� ��ȸ�� ����
	@Override
	public void increaseViewcnt(int bno) throws Exception {
		sqlSession.update("board.increaseViewcnt", bno);
	}
	// 07. �Խñ� ���ڵ� ����
	@Override
	public int countArticle(String searchOption, String keyword) throws Exception {
		// �˻��ɼ�, Ű���� �ʿ� ����
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return sqlSession.selectOne("board.countArticle", map);
	}
	
	// 08. �Խñ� ÷������ ���
	@Override
	public List<String> getAttach(int bno) {
		return sqlSession.selectList("board.getAttach", bno);
	}
	
	// 09. �Խñ� ÷������ ����ó��
	@Override
	public void deleteFile(String fullname) {
		sqlSession.delete("board.deleteAttach", fullname);
	}
	// 10. �Խñ� ÷������ ������Ʈ ó��
	@Override
	public void updateAttach(String fullName, int bno) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fullName", fullName);
		map.put("bno", bno);
		sqlSession.insert("board.updateAttach", map);
		
	}

}
