package kr.human.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import kr.human.security.vo.MemVO;
/*
2. 시큐리티에서 현재의 VO를 사용하려면 두번째로  다음과 같이 
   서비스 인터페이스가를 UserDetailsService를 상속하도록 한다.
 */
public interface MemService  extends UserDetailsService{
	void insertMem(MemVO memVO);
	MemVO selectByidx(int idx);
	MemVO selectByUserid(String userid);
}
