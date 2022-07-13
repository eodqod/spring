package kr.human.aop.aspect;

import org.aspectj.lang.JoinPoint;

public class EmployeeAspect {
	private long startTime, endTime;
	
	public void beforeLog(JoinPoint joinPoint) {
		startTime = System.currentTimeMillis();
		System.out.println("EmployeeAspect.beforeLog() 실행 : " + joinPoint.getSignature().getName());
	}
	
	public void afterLog(JoinPoint joinPoint) {
		endTime = System.currentTimeMillis();
		System.out.println("EmployeeAspect.afterLog() 실행 : " + joinPoint.getSignature().getName());
		System.out.println(joinPoint.getSignature().getName() + "의 실행시간 : " + (endTime-startTime) + "ms");
	}
	
	public void afterReturningLog(Object returnValue) {
		System.out.println("EmployeeAspect.afterReturingLog() 실행 : " + returnValue);
	}

	public void afterThrowingLog(Exception exception) {
		System.out.println("EmployeeAspect.afterThrowingLog() 실행 : " + exception);
	}
}
