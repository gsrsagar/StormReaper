///*package com.mphasis.shipproject.config;
//
//import java.util.Arrays;
//
//import org.apache.log4j.Logger;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//@Aspect
//@Component
//public class AspectHelper {
//final static Logger logger=Logger.getLogger(AspectHelper.class);
//@Pointcut(value="execution (* com.mphasis.demo.controller.*.*(..))")
//public void myPointcut() {
//}
//@Around("myPointCut()")
//public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable
//{
//ObjectMapper mapper=new ObjectMapper();
//String methodName=pjp.getSignature().getName();
//String className=pjp.getTarget().getClass().toString();
//Object[] array=pjp.getArgs();
//logger.info("method invoked"+methodName+"Class Name"+className+"arguments:"+mapper.writeValueAsString(array));
//Object object=pjp.proceed();
//logger.info("class Name"+className+"method name"+methodName+"Response"+mapper.writeValueAsString(object));
//return object;                                
//}
//
//  @Before("execution (* com.mphasis.shipproject.dao.(..))")
//  public void beforeMethod(JoinPoint joinPoint)
//  {
//	  System.out.println("Aspect called");
//	  System.out.println(joinPoint.getSignature().getName());
//System.out.println(Arrays.toString(joinPoint.getArgs()));
//  }
// @After("execution (* com.mphasis.shipproject.dao.(..))")
// public void afterMethod(JoinPoint joinPoint)
// {
//  System.out.println("Aspect called After");
//	  System.out.println(joinPoint.getSignature().getName());
//  }
//}
//*/
//
//
//
//
//
//
//package com.mphasis.stormreaper.config;
//
//
//
//	import java.util.Arrays;
//
//import org.apache.log4j.Logger;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//	public class AspectHelper {
//
//		  final static Logger logger= Logger.getLogger(AspectHelper.class);
//		
//		
//		 @Pointcut(value="execution(* com.mphasis.controllers.*.*(..))")
//		public void myPointCut()
//		{
//			
//		}		 @Around("myPointCut()")
//			public Object applicationLogger(ProceedingJoinPoint pjp)throws Throwable{
//				ObjectMapper mapper=new ObjectMapper();
//				String methodName=pjp.getSignature().getName();
//				String className=pjp.getTarget().getClass().toString();
//				Object[] array=pjp.getArgs();
//				logger.info("method invoked"+methodName+"Class name"+className+"arguments "+mapper.writeValueAsString(array));
//				Object object=pjp.proceed();
//				logger.info("Class name"+className+"method name"+methodName+"Response"+mapper.writeValueAsString(object)); 
//				return object;
//			}
//		
//	
//		
//	                @Before("execution(* com.mphasis.*.*(..))")
//	                public void beforeMethod(JoinPoint joinPoint)
//	                {
//	                                System.out.println("Aspect Called");
//	                                System.out.println(joinPoint.getSignature().getName());
//	                                System.out.println(Arrays.toString(joinPoint.getArgs())); 
//	                }
//	                
//	                @After("execution(* com.mphasis.*.*(..))")
//	                public void afterMethod(JoinPoint joinPoint)
//	                {
//	                                System.out.println("Aspect Called");
//	                                System.out.println(joinPoint.getSignature().getName());
//
//	                }
//	                
//	                
//	}
//
//
