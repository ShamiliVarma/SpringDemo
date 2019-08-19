package org.arpit.java2blog.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class CountryLogAspect {

	long startTime;
    long endTime;
	
	@Before("execution(* org.arpit.java2blog.controller.CountryController.*(..))")
	public void logMethodNames(JoinPoint jp) {
		
		System.out.println("Started Executing "+jp.getSignature().getName());
		
	}
	
	@After("execution(* org.arpit.java2blog.controller.CountryController.*(..))")
	public void logMethodNamesAfter(JoinPoint jp) {
		
		System.out.println("Completed Executing "+jp.getSignature().getName());
	}
	

	@Before("execution(* org.arpit.java2blog.controller.EmployeeController.*(..))")
	public void logMethods(JoinPoint jp) {
		
		System.out.println("Started Executing in Employee Controller"+jp.getSignature().getName());
		
	}
	
	@After("execution(* org.arpit.java2blog.controller.EmployeeController.*(..))")
	public void logMethodsAfter(JoinPoint jp) {
		
		System.out.println("Completed Executing in Employee Controller "+jp.getSignature().getName());
	}
	
	@Around("execution(* org.arpit.java2blog.controller.EmployeeController.*(..))")
	public Object logMethodAround(ProceedingJoinPoint proceedingJoinPoint) {
		System.out.println("Around Method "+proceedingJoinPoint.getSignature().getName());
		Object result = null;
		Object[] args = proceedingJoinPoint.getArgs();
	      if(args.length>0){
	         System.out.print("Arguments passed: " );
	         for (int i = 0; i < args.length; i++) {
	            System.out.print("arg "+(i+1)+": "+args[i]);
	         }
	      }
	      
		try {
			startTime = System.nanoTime();
			 result =proceedingJoinPoint.proceed(args);
			 endTime =System.nanoTime();
		} catch (Throwable e) {
			System.out.println("execption :: "+e.getMessage());
		}
	      System.out.println("Done with around method :: Time taken to execute "+
	    		  			proceedingJoinPoint.getSignature().getName()+" is "+((endTime-startTime)/1000000)+"ms");
	      return result;
	}

}
