package kr.human.di.vo;

import lombok.Data;

// 싱글톤으로 만들어 놓은 객체를 어떻게 등록을 할까요?
@Data
public class Geeks {
    // 정적 객체
    public static final Geeks instance = new Geeks();
     
    // private 생성자
    private Geeks() {}
     
    // 객체 얻기 메서드
    public static Geeks getInstance() {
        return instance;
    }
    // 일반 메서드
    public void geeksMessage() {
        System.out.println("환영합니다. 정적 팩토리 메소드가 잘 작동하는 DI");
    }
}