package Aspects;



import org.apache.log4j.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.revature.models.User;

@Aspect
@Component
public class LoggingAspects {
	private static Logger log = Logger.getRootLogger();
	
	
	@AfterThrowing("within(com.revature.services)")
	public void logAfterExceptionUS(JoinPoint jp) {
		log.error(jp.getSignature()+ " threw an exception");
	}
	
	@AfterThrowing("within(com.revature.controllers)")
	public void logAfterExceptionGS(JoinPoint jp) {
		log.error(jp.getSignature()+ " threw an exception");
	}
	@AfterThrowing("within(com.revature.util.EmailUtil)")
	public void logAfterExceptionEmail(JoinPoint jp) {
		log.error(jp.getSignature()+ " threw an exception");
	}
	
	@AfterThrowing("within(com.revature.repositories)")
	public void logAfterExceptionRepo(JoinPoint jp) {
		log.error(jp.getSignature()+ " threw an exception");
		
	}
	@After("execution(User createUser(.))")
	public void logWhenUsersAreCreated(JoinPoint jp) {
		log.info("A user was created.");
	}
	
	@After("execution(User deleteUser(.))")
	public void logWhenUserIsDeleted(JoinPoint jp) {
		log.info(jp.getSignature().getName() + " was deleted.");
	}
	
}
