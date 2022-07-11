package kr.human.job.app;

import org.springframework.scheduling.annotation.Scheduled;

public class MyBean {

	@Scheduled(fixedRate=5000)
    public void printMessage() {
        System.out.println("나는 스프링 스케줄러에 의해서 호출이 됩니다.!!!!!!!!!!!!!!!!!!!!!!!");
    }
	
	@Scheduled(fixedRate=3000, initialDelay = 2000)
    public void printMessage2() {
    	System.out.println("나는 스프링 스케줄러에 의해서 호출이 됩니다.~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
	@Scheduled(cron = "0/2 * * * * MON-FRI")
    public void printMessage3() {
    	System.out.println("나는 스프링 스케줄러에 의해서 호출이 됩니다.^^^^^^^^^^^^^^^^^^^^^^^");
    }
}