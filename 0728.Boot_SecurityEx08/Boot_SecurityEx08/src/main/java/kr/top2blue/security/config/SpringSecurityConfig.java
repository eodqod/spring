package kr.top2blue.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig{
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/welcome").hasAnyRole("USER", "ADMIN")
		.antMatchers("/getEmployees").hasAnyRole("USER", "ADMIN")
		.antMatchers("/addNewEmployee").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").permitAll()
		.and()
		.logout().permitAll();

	    return http.build();
	}
	
	@Autowired
	private DataSource dataSource;
	
	//Enable jdbc authentication
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
        .jdbcAuthentication()
        .passwordEncoder(new BCryptPasswordEncoder())
        .dataSource(dataSource)
        .authoritiesByUsernameQuery("select Username,role from roles where Username = ?")
        .usersByUsernameQuery("select Username, Password, Enabled from Users where Username = ?")
        ;
    }
    
	//	@Autowired
	//	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
	//		authenticationMgr
	//		.inMemoryAuthentication()
	//		.withUser("admin").password("$2a$10$X0qzsQU2QHANeSAtK6x9v.NkBT5MDjG1p6rayU8HBiR12lNAfXJVK").authorities("ROLE_USER","ROLE_ADMIN")
	//		.and()
	//		.withUser("user").password("$2a$10$X0qzsQU2QHANeSAtK6x9v.NkBT5MDjG1p6rayU8HBiR12lNAfXJVK").authorities( "ROLE_USER");
	//	}
}
/* 예전 */
/*
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        	.defaultSuccessUrl("/index", true)
        	.permitAll()
        .and()
        	.logout();
    }
}
*/