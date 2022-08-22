package kr.human.security.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.human.security.vo.MemVO;

@Mapper
public interface MemDAO {
	void insertMem(MemVO memVO);
	MemVO selectByidx(int idx);
	MemVO selectByUserid(String userid);
	int selectMaxIdx();
}
