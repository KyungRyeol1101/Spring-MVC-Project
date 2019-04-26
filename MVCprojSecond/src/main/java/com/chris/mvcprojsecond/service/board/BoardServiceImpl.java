package com.chris.mvcprojsecond.service.board;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chris.mvcprojsecond.model.board.dao.BoardDAO;
import com.chris.mvcprojsecond.model.board.dto.BoardVO;
 
@Service
public class BoardServiceImpl implements BoardService {
    
	@Inject
	BoardDAO boardDao;
	
	// 01. �Խñ۾���
	@Transactional // Ʈ����� ó�� �޼���� ����
	@Override
	public void create(BoardVO vo) throws Exception {
		String title = vo.getTitle();
		String content = vo.getContent();
		String writer = vo.getWriter();
		// *�±׹��� ó�� (< ==> &lt; > ==> &gt;)
		// replace(A, B) A�� B�� ����
		title = title.replace("<", "&lt;");
		title = title.replace("<", "&gt;");
		writer = writer.replace("<", "&lt;");
		writer = writer.replace("<", "&gt;");
		// *���鹮�� ó��  
		title = title.replace("  ",	"&nbsp;&nbsp;");
		writer = writer.replace("  ",	"&nbsp;&nbsp;");
		// *�ٹٲ� ����ó��
		content = content.replace("\n", "<br>");
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		// �Խù� ���
		boardDao.create(vo);
		// �Խù��� ÷������ ���� ���
		String[] files = vo.getFiles(); // ÷������ �迭
		if(files == null) return; // ÷�������� ������ �޼��� ����
		// ÷�����ϵ��� ������ tbl_attach ���̺� insert
		for(String name : files){ 
			boardDao.addAttach(name);
		}
		
	}
	// 02. �Խñ� �󼼺���
	@Override
	public BoardVO read(int bno) throws Exception {
		return boardDao.read(bno);
	}
	// 03. �Խñ� ����
	@Transactional
	@Override
	public void update(BoardVO vo) throws Exception {
		boardDao.update(vo);
		// ÷������ ���� ���
		String[] files = vo.getFiles(); // ÷������ �迭
		// ÷�������� ������ ����
		if(files == null) return;
		// ÷�����ϵ��� ������ tbl_attach ���̺� insert
		for(String name : files){
			boardDao.updateAttach(name, vo.getBno());
		}
	}
	// 04. �Խñ� ����
	@Override
	public void delete(int bno) throws Exception {
		boardDao.delete(bno);
	}
	// 05. �Խñ� ��ü ���
	@Override
	public List<BoardVO> listAll(int start, int end, String searchOption, String keyword) throws Exception {
		return boardDao.listAll(start, end, searchOption, keyword);
	}
	
	// 06. �Խñ� ��ȸ�� ����
	@Override
	public void increaseViewcnt(int bno, HttpSession session) throws Exception {
		long update_time = 0;
		// ���ǿ� ����� ��ȸ�ð� �˻�
		// ���ʷ� ��ȸ�� ��� ���ǿ� ����� ���� ���� ������ if���� ����X
		if(session.getAttribute("update_time_"+bno) != null){
								// ���ǿ��� �о����
			update_time = (long)session.getAttribute("update_time_"+bno);
		}
		// �ý����� ����ð��� current_time�� ����
		long current_time = System.currentTimeMillis();
		// �����ð��� ��� �� ��ȸ�� ���� ó�� 24*60*60*1000(24�ð�)
		 // �ý�������ð� - �����ð� > �����ð�(��ȸ�� ������ �����ϵ��� ������ �ð�)
		if(current_time - update_time > 5*1000){
			boardDao.increaseViewcnt(bno);
			// ���ǿ� �ð��� ���� : "update_time_"+bno�� �ٸ������� �ߺ����� �ʰ� ����� ��
			session.setAttribute("update_time_"+bno, current_time);
			
		}
	}
	// 07. �Խñ� ���ڵ� ����
	@Override
	public int countArticle(String searchOption, String keyword) throws Exception {
		return boardDao.countArticle(searchOption, keyword);
	}
	
	// 08. �Խñ��� ÷������ ���
	@Override
	public List<String> getAttach(int bno) {
		return boardDao.getAttach(bno);
	}
	// 09. �Խñ��� ÷������ ���� ó��
	@Override
	public void deleteFile(String fullname) {
		boardDao.deleteFile(fullname);
	}
}