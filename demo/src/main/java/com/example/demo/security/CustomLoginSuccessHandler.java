package com.example.demo.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j2;


@Log4j2
//로그인 후 처리해야되는 것들 여기서 처리
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		
		log.info("Login success");
		
		//Collection<Authority> => List<String> 타입으로 쓰기 편하게 변경
		List<String> roleNames = new ArrayList<>();
		auth.getAuthorities().forEach(authority -> {roleNames.add(authority.getAuthority()); });
		
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/empList");
		} else {
			response.sendRedirect("/hello");
		}
	}

}