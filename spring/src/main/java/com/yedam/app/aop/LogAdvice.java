package com.yedam.app.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//@Slf4j
@Aspect		//aspect
@Component //빈등록

public class LogAdvice {
	
	@Pointcut("execution(* com.yedam.app.emp..*Impl.*(..))")//* 어떤 리턴 타입이든 상관 없이 모두 / emp..*Impl 은 emp 하위 패키지 중 모든 Impl로 끝나는 패키지 / Impl.*(..) *어떤 메서드든 ..어떤 인수든 다
	public void allpointcut() {}                            // * com - 꼭 띄어쓰기!!            
	
	@Before("allpointcut()") 
	public void logBefore(JoinPoint jp) {                             
		//log.info("[log before]");
		System.out.println("[log before]");
		
		String name = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println(name + ": "); //호출하는 서비스이름
		if(args != null) {
			for(Object arg : args) {
				System.out.println(arg); //파라미터값 다
			}
		}
	
	}
	
}
