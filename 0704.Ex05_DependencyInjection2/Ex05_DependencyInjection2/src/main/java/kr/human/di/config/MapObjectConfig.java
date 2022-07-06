package kr.human.di.config;


import java.util.Map;
import java.util.TreeMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.human.di.vo.MapObject;

@Configuration
public class MapObjectConfig {
	
	@Bean(name = "mapObj1")
	public MapObject mapObject1() { // 생성자
		Map<String, Integer> map = new TreeMap<>();
		map.put("computer", 1285400);
		map.put("mouse", 123413);
		map.put("keyboard", 123412);
		MapObject mapObject = new MapObject();
		return mapObject;
	}
	
	@Bean(name = "mapObj2")
	public MapObject mapObject2() { // Setter
		Map<String, Integer> map = new TreeMap<>();
		map.put("computer", 1285400);
		map.put("mouse", 123413);
		map.put("keyboard", 123412);
		MapObject mapObject = new MapObject();
		mapObject.setMap(map);
		return mapObject;
	}
	
	@Bean(name = "map")
	public Map<String, Integer> getMap(){
		Map<String, Integer> map = new TreeMap<>();
		map.put("computer", 1285400);
		map.put("mouse", 123413);
		map.put("keyboard", 123412);
		return map;
	}
	
	@Bean(name = "mapObj3")
	public MapObject mapObject3() { // 참조
		MapObject mapObject = new MapObject();
		mapObject.setMap(getMap());
		return mapObject;
	}

}
