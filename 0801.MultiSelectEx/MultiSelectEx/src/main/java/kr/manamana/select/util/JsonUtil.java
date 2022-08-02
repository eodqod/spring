package kr.manamana.select.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kr.manamana.select.vo.AreaVO;

public class JsonUtil {
	// 리소스의 데이터 읽기
	final static DefaultResourceLoader loader = new DefaultResourceLoader();
	final static Logger logger = LoggerFactory.getLogger(JsonUtil.class);
	public static List<AreaVO> readJson(String fileName){
		List<AreaVO> list = null;
		Gson gson = new Gson();
		try {
			Resource resource = loader.getResource("classpath:" + fileName);
			logger.info(resource.toString());
			InputStreamReader isr = new InputStreamReader(resource.getInputStream());
			list = gson.fromJson(isr, new TypeToken<List<AreaVO>>() {}.getType());
			logger.info("List : {}", list );
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static List<AreaVO> readIdAear(String fileName, String id){
		List<AreaVO> list = readJson(fileName);
		List<AreaVO> idList = new ArrayList<AreaVO>();
		for(AreaVO vo : list) {
			if(vo.getId().startsWith(id) && vo.getId().length()>2 && vo.getId().length()==5) {
				idList.add(vo);
			}
		}
		return idList;
	}
	public static List<AreaVO> readIdAear2(String fileName, String id){
		List<AreaVO> list = readJson(fileName);
		List<AreaVO> idList = new ArrayList<AreaVO>();
		for(AreaVO vo : list) {
			if(vo.getId().startsWith(id) && vo.getId().length()>5) {
				idList.add(vo);
			}
		}
		return idList;
	}
	public static List<AreaVO> readAear(String fileName){
		List<AreaVO> list = readJson(fileName);
		List<AreaVO> areaList = new ArrayList<AreaVO>();
		for(AreaVO vo : list) {
			if(vo.getId().length()==2) {
				areaList.add(vo);
			}
		}
		return areaList;
	}
}
