package com.chris.mvcprojsecond.model.shop.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProductVO {
	private int productId; // ��ǰ��ȣ
	private String productName; // ��ǰ�̸�
	private int productPrice; // ��ǰ����
	private String productDesc; // ��ǰ ������
	private String productUrl; // ��ǰ�̹��� ���
	private MultipartFile productPhoto; // ��ǰ�̹�������
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getProductUrl() {
		return productUrl;
	}
	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}
	public MultipartFile getProductPhoto() {
		return productPhoto;
	}
	public void setProductPhoto(MultipartFile productPhoto) {
		this.productPhoto = productPhoto;
	}
	@Override
	public String toString() {
		return "ProductVO [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productDesc=" + productDesc + ", productUrl=" + productUrl + ", productPhoto=" + productPhoto
				+ "]";
	}
}
