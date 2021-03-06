package com.revature.Aspects;

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
public class LoggingAspect {
	private static Logger log = Logger.getRootLogger();
	
	
	@AfterThrowing("within(com.revature.services.UserServiceImpl)")
	public void logAfterExceptionUS(JoinPoint jp) {
		log.error(jp.getSignature()+ " threw an exception");
	}
	@AfterThrowing("within(com.revature.services.GameServiceImpl)")
	public void logAfterExceptionGS(JoinPoint jp) {
		log.error(jp.getSignature()+ " threw an exception");
	}
	@AfterThrowing("within(com.revature.services.ImageService)")
	public void logAfterExceptionIS(JoinPoint jp) {
		log.error(jp.getSignature()+ " threw an exception");
	}
	
	@AfterThrowing("within(com.revature.controllers.UserController)")
	public void logAfterExceptionUC(JoinPoint jp) {
		log.error(jp.getSignature()+ " threw an exception");
	}
		@AfterThrowing("within(com.revature.controllers.GameController)")
		public void logAfterExceptionGC(JoinPoint jp) {
			log.error(jp.getSignature()+ " threw an exception");
	}
		@AfterThrowing("within(com.revature.controllers.ImageController)")
		public void logAfterExceptionIC(JoinPoint jp) {
			log.error(jp.getSignature()+ " threw an exception");
		}
		@AfterThrowing("within(com.revature.controllers.LoginController)")
		public void logAfterExceptionLC(JoinPoint jp) {
			log.error(jp.getSignature()+ " threw an exception");
		}
	@AfterThrowing("within(com.revature.util.EmailUtil)")
	public void logAfterExceptionEmail(JoinPoint jp) {
		log.error(jp.getSignature()+ " threw an exception");
	}
//	
//	@AfterThrowing("within(com.revature.repositories)")
//	public void logAfterExceptionRepo(JoinPoint jp) {
//		log.error(jp.getSignature()+ " threw an exception");
//		
//	}
	@After("execution( * createUser(..))")
	public void logWhenUsersAreCreated(JoinPoint jp) {
//	User u = (User) jp.getTarget();
		log.info("An acount was made");
	}
	
	@After("execution(void deleteUser(..))")
	public void logWhenUserIsDeleted(JoinPoint jp) {
		log.info("An account  was deleted.");
	}
	
}