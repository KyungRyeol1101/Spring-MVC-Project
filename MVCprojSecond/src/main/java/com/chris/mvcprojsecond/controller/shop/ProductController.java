package com.chris.mvcprojsecond.controller.shop;

import java.io.File;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.chris.mvcprojsecond.model.shop.dto.ProductVO;
import com.chris.mvcprojsecond.service.shop.ProductService;

@Controller
@RequestMapping("shop/product/*")
public class ProductController {
	@Inject
	ProductService productService;
	
	// 1. ��ǰ ��ü ���
	@RequestMapping("/list.do")
	public ModelAndView list(ModelAndView mav) {
		mav.setViewName("shop/productList");
		mav.addObject("list", productService.listProduct());
		return mav;
	}
	// 2. ��ǰ �󼼺���
	@RequestMapping("detail/{productId}")
	public ModelAndView detail(@PathVariable("productId") int productId, ModelAndView mav){
		mav.setViewName("/shop/productDetail");
		mav.addObject("vo", productService.detailProduct(productId));
		return mav;
	}
	
	// 3. ��ǰ��� ������ ����
	@RequestMapping("write.do")
	public String write(){
		return "/shop/productWrite";
	}
	
	// 4. ��ǰ��� ó�� ����
	@RequestMapping("insert.do")
	public String insert(ProductVO vo){
		String filename = "";
		// ÷������(��ǰ����)�� ������
		if(!vo.getProductPhoto().isEmpty()){
			filename = vo.getProductPhoto().getOriginalFilename();
			// ���ߵ��丮 - ���� ���ε� ���
			//String path = "C:\\Users\\kryoon\\Desktop\\workspace\\gitSpring\\mvcprojsecond\\src\\main\\webapp\\WEB-INF\\views\\images"; //
			// �������丮 - ���� ���ε� ���
			String path = "C:\\Users\\kryoon\\Desktop\\workspace\\spring\\"
							+ "\\.metadata\\.plugins\\org.eclipse.wst.server.core\\"
							+ "tmp0\\wtpwebapps\\mvcprojsecond\\WEB-INF\\views\\images\\";
			try {
				new File(path).mkdirs(); // ���丮 ����
				// �ӽõ��丮(����)�� ����� ������ ������ ���丮�� ����
				vo.getProductPhoto().transferTo(new File(path+filename));
			} catch (Exception e) {
				e.printStackTrace();
			}
			vo.setProductUrl(filename);
			productService.insertProduct(vo);
		}
		return "redirect:/shop/product/list.do";
	}
	
	// 5. ��ǰ ����(����) ������ ����
	@RequestMapping("edit/{productId}")
	public ModelAndView edit(@PathVariable("productId") int productId, ModelAndView mav){
		mav.setViewName("/shop/productEdit");
		mav.addObject("vo", productService.detailProduct(productId));
		return mav;
	}
	
	// 6. ��ǰ ����(����) ó�� ����
	@RequestMapping("update.do")
	public String update(ProductVO vo){
		String filename = "";
		// ÷������(��ǰ����)�� ����Ǹ�
		if(!vo.getProductPhoto().isEmpty()){
			filename = vo.getProductPhoto().getOriginalFilename();
			// ���ߵ��丮 - ���� ���ε� ���
			//String path = "C:\\Users\\kryoon\\Desktop\\workspace\\gitSpring\\mvcprojsecond\\src\\main\\webapp\\WEB-INF\\views\\images"; //
			// �������丮 - ���� ���ε� ���
			String path = "C:\\Users\\kryoon\\Desktop\\workspace\\spring\\"
							+ "\\.metadata\\.plugins\\org.eclipse.wst.server.core\\"
							+ "tmp0\\wtpwebapps\\mvcprojsecond\\WEB-INF\\views\\images\\";
			try {
				new File(path).mkdirs(); // ���丮 ����
				// �ӽõ��丮(����)�� ����� ������ ������ ���丮�� ����
				vo.getProductPhoto().transferTo(new File(path+filename));
			} catch (Exception e) {
				e.printStackTrace();
			}
			vo.setProductUrl(filename);
		// ÷�������� ������� ������
		} else {
			// ������ ���ϸ�
			ProductVO vo2 = productService.detailProduct(vo.getProductId());
			vo.setProductUrl(vo2.getProductUrl());
		}
		productService.updateProduct(vo);
		return "redirect:/shop/product/list.do";
	}
	
	// 7. ��ǰ ���� ó�� ����
	@RequestMapping("delete.do")
	public String delete(@RequestParam int productId){
		// ��ǰ �̹��� ����
		String filename = productService.fileInfo(productId);
		String path = "C:\\Users\\kryoon\\Desktop\\workspace\\spring\\"
				+ "\\.metadata\\.plugins\\org.eclipse.wst.server.core\\"
				+ "tmp0\\wtpwebapps\\mvcprojsecond\\WEB-INF\\views\\images\\";
		// ��ǰ �̹��� ����
		if(filename != null){
			File file = new File(path+filename);
			// ������ �����ϸ�
			if (file.exists()){ 
				file.delete(); // ���� ����
			}
		}
		// ���ڵ� ����
		productService.deleteProduct(productId);
		
		return "redirect:/shop/product/list.do";
	}
}	