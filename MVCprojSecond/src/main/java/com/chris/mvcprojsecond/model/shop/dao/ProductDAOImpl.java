package com.chris.mvcprojsecond.model.shop.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.chris.mvcprojsecond.model.shop.dto.ProductVO;


@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Inject
	SqlSession sqlSession;
	
	// 01. ��ǰ���
	@Override
	public List<ProductVO> listProduct() {
		return sqlSession.selectList("product.listProduct");
	}
	// 02. ��ǰ��
	@Override
	public ProductVO detailProduct(int productId) {
		return sqlSession.selectOne("product.detailProduct", productId);
	}
	// 03. ��ǰ����
	@Override
	public void updateProduct(ProductVO vo) {
		sqlSession.update("product.updateProduct", vo);

	}
	// 04. ��ǰ����
	@Override
	public void deleteProduct(int productId) {
		sqlSession.delete("product.deleteProduct", productId);
	}
	// 05. ��ǰ �߰�
	@Override
	public void insertProduct(ProductVO vo) {
		sqlSession.insert("product.insertProduct", vo);
	}
	// 06. ��ǰ�̹��� ������ ���� �̹������� ����
	@Override
	public String fileInfo(int productId) {
		return sqlSession.selectOne("product.fileInfo",productId);
	}
}
