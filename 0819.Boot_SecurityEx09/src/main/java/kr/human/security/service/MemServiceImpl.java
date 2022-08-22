package kr.human.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.human.security.dao.MemDAO;
import kr.human.security.vo.MemVO;
import lombok.extern.slf4j.Slf4j;
/*
3. 시큐리티에서 현재의 VO를 사용하려면 두번째로  다음과 같이 
   UserDetailsService를 상속한 서비스 인터페이스가를 구현 하도록 한다.
   
   public MemVO loadUserByUsername(String username) throws UsernameNotFoundException {}
   위 메서드에서 리턴 타입을 UserDetails을 구현한 VO로 바꿔주고
   DAO에서  Userid로 VO를 얻어 리턴한다.
 */
@Service("memService")
@Slf4j
public class MemServiceImpl implements MemService{

	@Autowired
	private MemDAO memDAO;
	
	@Override
	public MemVO loadUserByUsername(String username) throws UsernameNotFoundException {
		MemVO memVO = null;
		memVO = memDAO.selectByUserid(username);
        if (memVO == null){
            throw new UsernameNotFoundException("User not authorized.");
        }
		return memVO;
	}
	@Override
	public void insertMem(MemVO memVO) {
		if(memVO!=null) {
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			memVO.setPassword(bCryptPasswordEncoder.encode(memVO.getPassword()));
			memVO.setRole("ROLE_USER");
			memDAO.insertMem(memVO);
		}
	}
	@Override
	public MemVO selectByidx(int idx) {
		MemVO memVO = memDAO.selectByidx(idx);
		log.info("selectByidx : {}", memVO);
		return memVO;
	}
	@Override
	public MemVO selectByUserid(String userid) {
		MemVO memVO = memDAO.selectByUserid(userid);
		log.info("selectByUserid : {}", memVO);
		return memVO;
	}
}
