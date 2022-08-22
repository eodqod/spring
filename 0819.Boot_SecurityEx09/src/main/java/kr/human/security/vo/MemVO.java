package kr.human.security.vo;
/*
create table mem(
	idx int primary key auto_increment,
	userid varchar(100) not null,
	password varchar(100) not null,
	name varchar(100) not null
	role varchar(400) not null
);

1. 시큐리티에서 현재의 VO를 사용하려면 첫번쨰 다음과 같이 VO를 작성해야 한다.
	VO에서 UserDetails 인터페이스를 구현한다.
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {}
	위메서드에서 권한을 만들어 리턴해 주도록한다.
	여기서는 	"ROLE_ADMIN, ROLE_USER" 형태의 스트링을 리스트로 변환하여 리턴하도록 구현함
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemVO implements UserDetails{
	private static final long serialVersionUID = 7026235725773590570L;
	private int idx;
	private String userid;
	private String password;
	private String name;
	private String role;  // ROLE_ADMIN, ROLE_USER 형태로 저장
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// return Collections.singletonList(new SimpleGrantedAuthority(role));
		List<GrantedAuthority> authorities = new ArrayList<>();
		// ROLE_ADMIN, ROLE_USER 형태로 저장되었을떄
		String[] roles = role.split(",");
		for(int i=0;i<roles.length;i++) {
			authorities.add(new SimpleGrantedAuthority(roles[i].trim()));
		}
        return authorities;
	}
	@Override
	public String getUsername() {
		return userid;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
}
