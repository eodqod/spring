package kr.human.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import kr.human.security.service.MemService;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig{
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/error**","/css/**", "/js/**", "/images/**","/upload/**").permitAll() 
		.antMatchers("/join","/joinOk","/api/**").permitAll() 
		.antMatchers("/user/**").hasRole("USER")
		.antMatchers("/admin/**").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login")
		.usernameParameter("username")
		.passwordParameter("password")
		//.loginProcessingUrl("/login_proc") 
		.successHandler(new LoginSuccessHandler())
		//.defaultSuccessUrl("/")
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.logoutSuccessUrl("/")
		.permitAll();

	    return http.build();
	}
	
//	@Autowired
//	private DataSource dataSource;
	
	@Autowired
	private MemService memService;
	
	//Enable jdbc authentication
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
    	
    	// 4. 시큐리티에서 현재의 VO를 사용하려면 
    	//    여기에서 회원 정보를 가져와 인증 영역에 정보를 저장할 서비스를 등록해 준다.
    	//    등록해주는 서비스는 UserDetailsService를 구현한 서비스이어야 한다.
    	
		auth.userDetailsService(memService).passwordEncoder(new BCryptPasswordEncoder());
    	
		/*
		 * auth .jdbcAuthentication() .passwordEncoder(new BCryptPasswordEncoder())
		 * .dataSource(dataSource)
		 * .authoritiesByUsernameQuery("select Username,role from roles where Username = ?"
		 * )
		 * .usersByUsernameQuery("select Username, Password, Enabled from Users where Username = ?"
		 * ) ;
		 */
    }

}
