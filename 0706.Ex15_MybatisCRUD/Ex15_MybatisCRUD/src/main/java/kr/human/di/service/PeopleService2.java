package kr.human.di.service;

import java.util.HashMap;
import java.util.List;

import kr.human.di.vo.PeopleVO;

public interface PeopleService2 {
	// 한개얻기
	HashMap<String, Object> selectByIdx(int idx);
	// 목록보기
	List<HashMap<String, Object>> selectList();
	// 저장하기
	boolean insert(HashMap<String, Object> map);
}
