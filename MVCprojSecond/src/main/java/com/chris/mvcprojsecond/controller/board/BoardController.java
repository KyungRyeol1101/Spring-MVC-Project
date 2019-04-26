package com.chris.mvcprojsecond.controller.board;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.chris.mvcprojsecond.model.board.dto.BoardVO;
import com.chris.mvcprojsecond.service.board.BoardService;
import com.chris.mvcprojsecond.service.board.ReplyService;
import com.chris.mvcprojsecond.service.board.BoardPager;
@Controller    // ���� Ŭ������ ��Ʈ�ѷ� ��(bean)���� ���
@RequestMapping("/board/*")
public class BoardController {
private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	// �������� ���� => BoardServiceImpl ����
	// IoC �������� ����
	@Inject
	BoardService boardService;
	@Inject
	ReplyService replyService;
	
	// 01. �Խñ� ���
	@RequestMapping("list.do")
	// @RequestParam(defaultValue="") ==> �⺻�� �Ҵ�
	public ModelAndView list(@RequestParam(defaultValue="title") String searchOption,
							@RequestParam(defaultValue="") String keyword,
							@RequestParam(defaultValue="1") int curPage) throws Exception{
		// ���ڵ��� ���� ���
		int count = boardService.countArticle(searchOption, keyword);
		// ������ ������ ���� ó��
		BoardPager boardPager = new BoardPager(count, curPage);
		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();
		
		List<BoardVO> list = boardService.listAll(start, end, searchOption, keyword);
		
		// �����͸� �ʿ� ����
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list); // list
		map.put("count", count); // ���ڵ��� ����
		map.put("searchOption", searchOption); // �˻��ɼ�
		map.put("keyword", keyword); // �˻�Ű����
		map.put("boardPager", boardPager);
		// ModelAndView - �𵨰� ��
		ModelAndView mav = new ModelAndView();
		/*mav.addObject("list", list); // �����͸� ����
		mav.addObject("count", count);
		mav.addObject("searchOption", searchOption);
		mav.addObject("keyword", keyword);*/
		mav.addObject("map", map); // �ʿ� ����� �����͸� mav�� ����
		mav.setViewName("board/list"); // �並 list.jsp�� ����
		return mav; // list.jsp�� List�� ���޵ȴ�.
	}
	// 02_01. �Խñ� �ۼ�ȭ��
	// @RequestMapping("board/write.do")
	// value="", method="���۹��"
	@RequestMapping(value="write.do", method=RequestMethod.GET)
	public String write(){
		return "board/write"; // write.jsp�� �̵�
	}
	
	// 02_02. �Խñ� �ۼ�ó��
	@RequestMapping(value="insert.do", method=RequestMethod.POST)
	public String insert(@ModelAttribute BoardVO vo, HttpSession session) throws Exception{
		// session�� ����� userId�� writer�� ����
		String writer = (String) session.getAttribute("userId");
		// vo�� writer�� ����
		vo.setWriter(writer);
		boardService.create(vo);
		return "redirect:list.do";
	}
	
	// 03. �Խñ� �󼼳��� ��ȸ, �Խñ� ��ȸ�� ���� ó��
	// @RequestParam : get/post������� ���޵� ���� 1��
	// HttpSession ���ǰ�ü
	@RequestMapping(value="view.do", method=RequestMethod.GET)
	public ModelAndView view(@RequestParam int bno, @RequestParam int curPage, @RequestParam String searchOption,
							@RequestParam String keyword, HttpSession session) throws Exception{
		// ��ȸ�� ���� ó��
		boardService.increaseViewcnt(bno, session);
		// ��(������)+��(ȭ��)�� �Բ� �����ϴ� ��ü
		ModelAndView mav = new ModelAndView();
		// ���� �̸�
		mav.setViewName("board/view");
		// �信 ������ ������
		// ����� �� : ����� �����ϴ� �Խù��� ����ó�� �����ϱ� ����
		mav.addObject("count", replyService.count(bno)); 
		mav.addObject("dto", boardService.read(bno));
		mav.addObject("curPage", curPage);
		mav.addObject("searchOption", searchOption);
		mav.addObject("keyword", keyword);
		logger.info("mav:", mav);
		return mav;
	}
	
	// 04. �Խñ� ����
	// ������ �Է��� ������� @ModelAttribute BoardVO vo�� ���޵�
	@RequestMapping(value="update.do", method=RequestMethod.POST)
	public String update(@ModelAttribute BoardVO vo) throws Exception{
		boardService.update(vo);
		return "redirect:list.do";
	}
	
	// 05. �Խñ� ����
	@RequestMapping("delete.do")
	public String delete(@RequestParam int bno) throws Exception{
		boardService.delete(bno);
		return "redirect:list.do";
	}
	
	// 06. �Խñ� ÷������ ���
	// http://loacalhost/spring02/board/getAttach/1
	// @PathVariable : parameter�� �ƴ� url�� ���Ե� ����
	// @RequestParam : parameter����
	@RequestMapping("/getAttach/{bno}")
	@ResponseBody // view�� �ƴ� data�� ����
	public List<String> getAttach(@PathVariable("bno") int bno){
		return boardService.getAttach(bno);
	}
}