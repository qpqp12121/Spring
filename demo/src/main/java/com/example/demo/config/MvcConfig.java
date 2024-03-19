package com.example.demo.config;

	import org.springframework.context.annotation.Configuration;
	import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
	import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

	@Configuration
	public class MvcConfig implements WebMvcConfigurer {
		//https://spring.io/guides/gs/securing-web
		//security 설정 (권한 확인)

		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/home").setViewName("home");
			//registry.addViewController("/").setViewName("home"); //index 기본화면으로 만들어나서 충돌방지하기 위해 막음
			registry.addViewController("/hello").setViewName("hello");
			registry.addViewController("/login").setViewName("login");
		}

	}
