package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
@Aspect
@Order(1)
public class DemoLoggingAspect {
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String method = proceedingJoinPoint.getSignature().toShortString();
		System.out.println("@Around getFortune: "+ method);
		
		long begin = System.currentTimeMillis();
		proceedingJoinPoint.proceed();
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		System.out.println("Duration convert by @Around AOP:: "+ duration/1000);
		
		return null;
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("@After (Finally): "+ method);
	}
	
	@AfterThrowing(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing="exc")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("Excecuting by @AfterThrowing: " +method);
		
		System.out.println("The exception by @AfterThowing bypass: "+exc);
	}
	
	// Add new advice for AfterReturning on the findAccounts method
	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning="res")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> res) {
		String method = joinPoint.getSignature().toShortString();
		
		System.out.println("Method: "+method);
		System.out.println("Get list: "+ res);
		
		// Post-Process modify data
		convertAccountNameToUpperCase(res);
		System.out.println("Converted by @AfterReturning");
	}
	
	private void convertAccountNameToUpperCase(List<Account> res) {
		for (Account iterAcc: res) {
			iterAcc.setName(iterAcc.getName().toUpperCase());
		}
	}

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println(getClass()+ " beforeAddcountAdvice");
		
		//Display method
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("Method: " + methodSignature);
		//Display argument
		Object[] args = joinPoint.getArgs();
		
		for (Object iterArg : args) {
			if (iterArg instanceof Account) {
				Account theAccount = (Account) iterArg;
				
				System.out.println("The name: " + theAccount.getName());
				System.out.println("The level: "+ theAccount.getLevel());
			}
		}
	}
	
}
