package kr.human.app;

import java.time.LocalDateTime;

/**
 * 
 * @author human
 * -locale ko_KR -encoding UTF-8 -charset UTF-8 -docencoding UTF-8
 */
public class MyApp2 {
	/**
	 * 인사하는 함수
	 * @param name : 이름을 받는다.
	 * @return : "Hi " + name
	 */
	public String hello(String name) {
		return "Hi " + name;
	}
	
	/**
	 * 
	 * @return
	 */
	public LocalDateTime getToday() {
		return LocalDateTime.now();
	}
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int add(int a, int b) {
		return a+b;
	}
}
