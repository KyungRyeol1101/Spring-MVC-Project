package com.chris.mvcprojsecond.service.shop;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chris.mvcprojsecond.model.shop.dao.ProductDAO;
import com.chris.mvcprojsecond.model.shop.dto.ProductVO;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Inject
	ProductDAO productDao;
	
	// 01. ��ǰ���
		@Override
		public List<ProductVO> listProduct() {
			return productDao.listProduct();
		}
		// 02. ��ǰ��
		@Override
		public ProductVO detailProduct(int productId) {
			return productDao.detailProduct(productId);
		}
		// 03. ��ǰ����
		@Override
		public void updateProduct(ProductVO vo) {
			productDao.updateProduct(vo);
		}
		// 04. ��ǰ����
		@Override
		public void deleteProduct(int productId) {
			productDao.deleteProduct(productId);
		}
		// 05. ��ǰ�߰�
		@Override
		public void insertProduct(ProductVO vo) {
			productDao.insertProduct(vo);	
		}
		// 06. ��ǰ�̹��� ������ ���� �̹������� ����
		@Override
		public String fileInfo(int productId) {
			return productDao.fileInfo(productId);
		}
}
