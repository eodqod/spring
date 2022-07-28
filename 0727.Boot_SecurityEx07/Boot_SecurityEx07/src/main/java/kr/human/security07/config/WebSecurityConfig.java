package kr.human.security07.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@SuppressWarnings("deprecation")
//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/", "/home","/index").permitAll()
				.antMatchers("/hello").hasRole("USER")
				.antMatchers("/admin").hasRole("ADMIN")
				//.anyRequest().authenticated()
			.and()
				.exceptionHandling()
				.accessDeniedPage("/accessDenied")				
			.and()
				.formLogin()
				.loginPage("/login")
				//.failureHandler(customAuthFailureHandler)
				//.defaultSuccessUrl("/")
			.and()
				.logout()
				.permitAll()
				.logoutSuccessUrl("/login?logout=logout");
	}

	 @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    	PasswordEncoder encoder = 
	          PasswordEncoderFactories.createDelegatingPasswordEncoder();
	    	System.out.println(encoder.encode("123456"));
	    	auth
	          .inMemoryAuthentication()
	          .withUser("user")
	          .password(encoder.encode("123456"))
	          .roles("USER")
	          .and()
	          .withUser("admin")
	          .password(encoder.encode("123456"))
	          .roles("USER", "ADMIN");
	    }
}