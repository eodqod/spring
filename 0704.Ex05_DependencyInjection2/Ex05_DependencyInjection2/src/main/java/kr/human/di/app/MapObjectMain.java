package kr.human.di.app;

import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.human.di.vo.MapObject;

public class MapObjectMain {
	public static void main(String[] args) {
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("MapObject.xml");

		MapObject object = context.getBean("mapObj1", MapObject.class);
		System.out.println(object);
		
		MapObject object2 = context.getBean("mapObj2", MapObject.class);
		System.out.println(object2);
		
		MapObject object3 = context.getBean("mapObj3", MapObject.class);
		System.out.println(object3);
		
		Map<String, Integer> map = context.getBean("map", Map.class);
		System.out.println(map);
		
		context.close();
	}
}
