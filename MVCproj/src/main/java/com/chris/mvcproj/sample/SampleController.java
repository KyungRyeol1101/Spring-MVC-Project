package com.chris.mvcproj.sample;

import java.util.HashMap;
import java.util.Map;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
 
@Controller // ��Ʈ�ѷ� bean���� �ε�(���� Ŭ������ ��Ʈ�ѷ��� �޸𸮿� �ε������ش�)
public class SampleController {
    // �α� ��ü ����
    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
    
    @RequestMapping("sample/doA") // url pattern
    // ����Ÿ�� ���� void�� ���, mapping�� url pattern�̸��� ������ jsp�� �������Ѵ�.
    //public void doA(Model model){
    public String doA(Model model){
        logger.info("doA called...."); // �α� ���
        // model.addAttribute(key, value);
        // map�� ���� key, value������ �Ǿ��ִ�.
        model.addAttribute("message", "Ȩ������ �湮�� ȯ���մϴ�.");
        // ����Ÿ���� void�̸�, �޼��尡 ����� �Ŀ� doA.jsp�� ������
        return "sample/doB"; // doB.jsp�� ������
    }
    
    @RequestMapping("sample/doB") // url pattern
    public void doB(){
        logger.info("doB called....");
        // �޼��尡 ����� �Ŀ� doB.jsp�� ������
    }
    
    // ModelAndView : Model - �����������, Viewȭ��
    // �����Ϳ� �������� �������� ����
    // forward : �ּҺ���X , ȭ����ȯ, �뷮�� ������ ����
    // redirect : �ּҺ���O, ȭ����ȯ, �ҷ��� ������ ����(get��ĸ� ����)
    @RequestMapping("sample/doC") // url pattern
    public ModelAndView doC(){
        logger.info("doC called....");
        // �޼��尡 ����� �Ŀ� doC.jsp�� ������
        // �ʿ� ��ü�� ����
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("product", new ProductVO("����", 1000));
        // new ModelAndView("view�� �̸�", "map������", ��);
        return new ModelAndView("sample/doC", "map", map);
    }
    @RequestMapping("sample/doD")
    public String doD(){
        // redirect�� ���, return type�� String���� ����
        // doE.jsp�� �����̷�Ʈ
        return "redirect:/sample/doE";
        //return "sample/doE"; // ������
    }
    
    @RequestMapping("sample/doE")
    public void doE(){
        //doE.jsp�� ������
    }
    
}