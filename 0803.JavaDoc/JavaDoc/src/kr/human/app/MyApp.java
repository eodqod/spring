package kr.human.app;

import javax.swing.JFrame;

/**
 * 
 * @author human
 *
 */
public class MyApp {
	/*
	 * 나는 주석입니다.
	 */
	/**
	 * 나는 프로그램 시작점 입니다
	 * @param args : 명령행에서 인수를 배열로 받습니다.
	 */
	public static void main(String[] args) {
		System.out.println("Hello World!!!");
		System.out.println(hello("한사람"));
		JFrame frame = new JFrame("내가 만든 윈도우");
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	/**
	 * 인사하는 함수
	 * @param name : 이름을 받는다.
	 * @return : "Hi " + name
	 */
	public static String hello(String name) {
		return "Hi " + name;
	}
}
