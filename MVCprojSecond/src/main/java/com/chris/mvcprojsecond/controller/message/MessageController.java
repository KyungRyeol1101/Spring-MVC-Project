package com.chris.mvcprojsecond.controller.message;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chris.mvcprojsecond.model.message.dto.MessageVO;
import com.chris.mvcprojsecond.service.message.MessageService;

@RestController
@RequestMapping("/messages/*")
public class MessageController {
	@Inject
	MessageService service;
	// ResponseEntity	: HTTP�����ڵ� + ������  ����
	// @RequestBody		: Ŭ���̾�Ʈ => ���� (json �����Ͱ� �Էµ� ��)
	// @ResponsetBody	: ���� => Ŭ���̾�Ʈ (json) RestController������ ��������
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<String> addMessage(@RequestBody MessageVO vo){
		ResponseEntity<String> entity = null;
		try {
			service.addMessage(vo);
			// new ResponseEntity<�ڷ���>(���ϰ�, HTTP�����ڵ�);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}