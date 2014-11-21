package cn.yaofeng.finneen.rest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceMonitor {
	
	//private static final Logger logger = LoggerFactory.getLogger("service");
	private static final Logger logger = LoggerFactory.getLogger(ServiceMonitor.class);
	
	@Around("execution(* cn.yaofeng.finneen*..*Controller.*(..))")
	public Object logServiceTime(ProceedingJoinPoint joinPoint) throws Throwable{
		long start = System.currentTimeMillis();
		Object obj = joinPoint.proceed();
		logger.info(joinPoint.toString() + " time: " + (System.currentTimeMillis() - start) + "ms");
		return obj;
	}
}
