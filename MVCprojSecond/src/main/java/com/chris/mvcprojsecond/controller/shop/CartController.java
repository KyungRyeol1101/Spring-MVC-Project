package com.chris.mvcprojsecond.controller.shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.chris.mvcprojsecond.model.shop.dao.CartDAO;
import com.chris.mvcprojsecond.model.shop.dto.CartVO;
import com.chris.mvcprojsecond.service.shop.CartService;

@Controller
@RequestMapping("/shop/cart/*")
public class CartController {
	
	@Inject
	CartService cartService;
	
	// 1. ��ٱ��� �߰�
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute CartVO vo, HttpSession session){
		String userId = (String) session.getAttribute("userId");
		vo.setUserId(userId);
		// ��ٱ��Ͽ� ���� ��ǰ�� �ִ��� �˻�
		int count = cartService.countCart(vo.getProductId(), userId);
		if(count == 0){		
			// ������ insert
			cartService.insert(vo);
		} else {
			// ������ update
			cartService.updateCart(vo);
		}
		return "redirect:/shop/cart/list.do";
	}
	
	// 2. ��ٱ��� ���
	@RequestMapping("list.do")
	public ModelAndView list(HttpSession session, ModelAndView mav){
		Map<String, Object> map = new HashMap<String, Object>();
		String userId = (String) session.getAttribute("userId"); // session�� ����� userId
		List<CartVO> list = cartService.listCart(userId); // ��ٱ��� ���� 
		int sumMoney = cartService.sumMoney(userId); // ��ٱ��� ��ü �ݾ� ȣ��
		// ��ٱ��� ��ü ��׿� ���� ��ۺ� ����
		// ��۷�(10�����̻� => ����, �̸� => 2500��)
		int fee = sumMoney >= 100000 ? 0 : 2500;
		map.put("list", list);				// ��ٱ��� ������ map�� ����
		map.put("count", list.size());		// ��ٱ��� ��ǰ�� ����
		map.put("sumMoney", sumMoney);		// ��ٱ��� ��ü �ݾ�
		map.put("fee", fee); 				// ��۱ݾ�
		map.put("allSum", sumMoney+fee);	// �ֹ� ��ǰ ��ü �ݾ� 
		mav.setViewName("shop/cartList");	// view(jsp)�� �̸� ����
		mav.addObject("map", map);			// map ���� ����
		return mav;
	}
	
	// 3. ��ٱ��� ����
	@RequestMapping("delete.do")
	public String delete(@RequestParam int cartId){
		cartService.delete(cartId);
		return "redirect:/shop/cart/list.do";
	}
	
	// 4. ��ٱ��� ����
	@RequestMapping("update.do")
	public String update(@RequestParam int[] amount, @RequestParam int[] productId, HttpSession session) {
		// session�� id
		String userId = (String) session.getAttribute("userId");
		// ���ڵ��� ���� ��ū �ݺ��� ����
		for(int i=0; i<productId.length; i++){
			CartVO vo = new CartVO();
			vo.setUserId(userId);
			vo.setAmount(amount[i]);
			vo.setProductId(productId[i]);
			cartService.modifyCart(vo);
		}
		
		return "redirect:/shop/cart/list.do";
	}
}