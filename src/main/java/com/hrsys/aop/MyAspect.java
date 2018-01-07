package com.hrsys.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.hrsys.user.entity.User;



@Component
@Aspect//1.声明切面类
public class MyAspect {
	
	//2.声明切面类的切点（任意多个，切点之间可以组合，根据包、类、方法名、参数列表来匹配切入的点）(不会执行的普通方法-标记)
	@Pointcut("execution(public * *(..))")
	private void anyPublicOperation() {}
	
	@Pointcut("within(com.hrsys.*.service..*)")
	public void inServiceLayer() {}
	
	@Pointcut("anyPublicOperation() && inServiceLayer()")
	private void tradingOperation() {}
	
	//3.通知（增强，搭配切点使用）
		//AOP的5种通知（增强）：前置、后置、异常、最终、环绕
	@Before("tradingOperation() && args(user)")
	public void doAccessCheck(User user) {
		System.out.println(user.getUserName());
		System.out.println("前置通知--数据校验、事务开始、权限校验");
	}
	
	@AfterReturning("tradingOperation()")
	public void doReturn() {
		System.out.println("后置通知--事务关闭、数据过滤、操作成功日记");
	}
	
	@AfterThrowing("tradingOperation()")
	public void doThrowing() {
		System.out.println("异常通知--错误日记、统一异常处理");
	}
	
	@After("tradingOperation()")
	public void doAfter() {
		System.out.println("最终通知--事务回滚");
	}
	
	//环绕通知
//	@Around("tradingOperation()")
//	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
//		// start stopwatch
//		Object retVal = pjp.proceed();
//		// stop stopwatch
//		return retVal;
//	}
	
}
