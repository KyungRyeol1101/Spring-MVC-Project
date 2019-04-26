package com.chris.mvcprojsecond.model.shop.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.chris.mvcprojsecond.model.shop.dto.CartVO;

@Repository
public class CartDAOImpl implements CartDAO {
		
	@Inject
	SqlSession sqlSession;
	
	// 1. ��ٱ��� �߰�
	@Override
	public void insert(CartVO vo) {
		sqlSession.insert("cart.insertCart", vo);
	}
	// 2. ��ٱ��� ���
	@Override
	public List<CartVO> listCart(String userId) {
		return sqlSession.selectList("cart.listCart", userId);
	}
	// 3. ��ٱ��� ����
	@Override
	public void delete(int cartId) {
		sqlSession.delete("cart.deleteCart", cartId);
	}
	// 4. ��ٱ��� ����
	@Override
	public void modifyCart(CartVO vo) {
		sqlSession.update("cart.modifyCart", vo);
	}
	// 5. ��ٱ��� �ݾ� �հ�
	@Override
	public int sumMoney(String userId) {
		sqlSession.selectOne("cart.sumMoney", userId);
		return sqlSession.selectOne("cart.sumMoney", userId);
	}
	// 6. ��ٱ��� ��ǰȮ��
	@Override
	public int countCart(int productId, String userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productId", productId);
		map.put("userId", userId);
		return sqlSession.selectOne("cart.countCart", map);
	}
	// 7. ��ٱ��� ��ǰ���� ����
	@Override
	public void updateCart(CartVO vo) {
		sqlSession.update("cart.updateCart", vo);
	}
}