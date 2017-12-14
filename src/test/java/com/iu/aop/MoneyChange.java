package com.iu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MoneyChange {

	@Around("execution(* com.iu.aop..Trip.*(..))")
	public Object exchange(ProceedingJoinPoint joinPoint) {
		System.out.println("=============");
		System.out.println("원화를 달러로 교환");
		
		Object obj = null;
		try {
			obj = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("=============");		
		System.out.println("달러를 원화로 교환");
		
		return obj;
	}
}
