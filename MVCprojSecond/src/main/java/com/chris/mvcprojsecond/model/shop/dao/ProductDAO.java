package com.chris.mvcprojsecond.model.shop.dao;

import java.util.List;

import com.chris.mvcprojsecond.model.shop.dto.ProductVO;

public interface ProductDAO {
	// 01. ��ǰ���
	public List<ProductVO> listProduct();
	// 02. ��ǰ��
	public ProductVO detailProduct(int productId);
	// 03. ��ǰ����
	public void updateProduct(ProductVO vo);
	// 04. ��ǰ����
	public void deleteProduct(int productId);
	// 05. ��ǰ�߰�
	public void insertProduct(ProductVO vo);
	// 06. ��ǰ�̹��� ������ ���� �̹������� ����
	public String fileInfo(int productId);
}