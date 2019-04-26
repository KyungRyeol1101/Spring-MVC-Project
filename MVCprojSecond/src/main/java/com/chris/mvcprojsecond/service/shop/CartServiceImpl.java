package com.chris.mvcprojsecond.service.shop;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chris.mvcprojsecond.model.shop.dao.CartDAO;
import com.chris.mvcprojsecond.model.shop.dto.CartVO;

@Service
public class CartServiceImpl implements CartService {
	
	@Inject
	CartDAO cartDao;
	
	// 1. ��ٱ��� �߰�
	@Override
	public void insert(CartVO vo) {
		cartDao.insert(vo);
	}
	// 2. ��ٱ��� ���
	@Override
	public List<CartVO> listCart(String userId) {
		return cartDao.listCart(userId);
	}
	// 3. ��ٱ��� ����
	@Override
	public void delete(int cartId) {
		cartDao.delete(cartId);
	}
	// 4. ��ٱ��� ����
	@Override
	public void modifyCart(CartVO vo) {
		cartDao.modifyCart(vo);
	}
	// 5. ��ٱ��� �ݾ� �հ�
	@Override
	public int sumMoney(String userId) {
		return cartDao.sumMoney(userId);
	}
	// 6. ��ٱ��� ��ǰȮ��
	@Override
	public int countCart(int productId, String userId) {
		return cartDao.countCart(productId, userId);
	}
	// 7. ��ٱ��� ��ǰ���� ����
	@Override
	public void updateCart(CartVO vo) {
		cartDao.updateCart(vo);
	}
}
