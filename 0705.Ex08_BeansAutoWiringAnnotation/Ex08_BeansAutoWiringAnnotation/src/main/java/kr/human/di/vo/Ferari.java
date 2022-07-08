package kr.human.di.vo;

import org.springframework.stereotype.Component;

@Component("Ferari")
public class Ferari implements Car {
	public void getCarName() {
		System.out.println("This is Ferari");
	}
}