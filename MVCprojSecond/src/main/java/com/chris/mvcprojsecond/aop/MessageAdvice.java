package com.chris.mvcprojsecond.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// Advice : ��������� �����ϴ� Ŭ����
@Component // ��Ÿ bean
@Aspect // AOP bean
public class MessageAdvice {
	private static final Logger logger = LoggerFactory.getLogger(MessageAdvice.class);
	
	// @Before(���:ȣ����), @After(���:ȣ����), @Around(���:ȣ���� ��)
	@Before("execution(* com.example.spring02.service.message.MessageService*.*(..))")
	public void startLog(JoinPoint jp){
		// �ٽɾ����� Ŭ����,�ż���, �Ű����� �α� 
		logger.info("�ٽɾ��� �ڵ�����  : "+jp.getSignature());
		logger.info("�޼��� : "+jp.getSignature().getName());
		logger.info("�Ű�����:"+Arrays.toString(jp.getArgs()));
	}
	
	// method ���� �ð� Ȯ��, @Around : �ٽɾ��� ���Ŀ� �ڵ�ȣ��, ProceedingJoinPoint
	@Around("execution(* com.example.spring02.service.message.MessageService*.*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
		// �ٽɾ��� ���� ��
		long start = System.currentTimeMillis(); 
		// �ٽɾ��� ����
		Object result = pjp.proceed(); 
		// �ٽɾ��� ���� ��
		long end = System.currentTimeMillis(); 
		// �ٽɾ��� ����ð� ����
		logger.info(pjp.getSignature().getName()+"�޼��� ����ð�:"+(end-start));
		logger.info("==========================================");
		return result;
	}
}