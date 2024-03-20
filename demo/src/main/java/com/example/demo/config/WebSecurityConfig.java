package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.demo.security.CustomAccessDeniedHandler;
import com.example.demo.security.CustomLoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired UserDetailsService detailService; //아래처럼 bean으로 등록해도 되고
	
	@Bean
	public AccessDeniedHandler accessDeniedHandler() { //return타입은 상속받는 핸들러
		return new CustomAccessDeniedHandler(); //생성해서 @Bean 컨테이너에 담아줌 (컴포넌트생성과 같음)
	}
	
	@Bean
	public AuthenticationSuccessHandler successHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.antMatchers("/", "/home").permitAll() //아무나 접근 가능
				//.antMatchers("/emp/*") //url지정 가능
				.antMatchers("/empList").hasRole("ADMIN") //empList admin만 접근 가능하도록 함 //Role 변경하면 됨(등급명 등으로 테이블에 맞게)
				.anyRequest().authenticated() //로그인해야 가능
			)
//			.formLogin((form) -> form
//				.loginPage("/login")
//				.permitAll()
//			)
			.formLogin().loginPage("/login")
						.usernameParameter("userid") //login.html에서 기본형태를 바꿨으면 알려줘야 됨
						.loginProcessingUrl("/userlogin")
						.successHandler(successHandler())
						.permitAll()
			.and()
			//.logout((logout) -> logout.permitAll()) //람다식 아니면 아래 방법 사용(둘 다 같음 -*근데 아래 꼭 끝나면 .and() 같이 써주기)
			.logout().logoutSuccessUrl("/customLogout")
					 .permitAll()
			.and()
			//.exceptionHandling().accessDeniedHandler(accessDeniedHandler());
			.exceptionHandling(handler -> handler.accessDeniedHandler(accessDeniedHandler()))
		    //.csrf().disable()
			.userDetailsService(detailService)
			;
			
			
		return http.build();
	}

//detailService 만들어서 이제 사용X
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user =
//			 User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("1111")
//				.roles("USER")
//				.build();
//
//		
//		UserDetails admin =
//			 User.withDefaultPasswordEncoder()
//					.username("admin")
//					.password("1111")
//					.roles("ADMIN")
//					.build();
//
//		return new InMemoryUserDetailsManager(user, admin);
//	}
}
