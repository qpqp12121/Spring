package com.example.demo.di;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Setter;

@SpringBootTest
public class DITest {
	
	@Autowired //bean 꺼내 쓰기 (기본이 singleton방식)
	private Restaurant restaurant;
	
	@Setter(onMethod_ = {@Autowired})
	private Restaurant restaurant1;
	
	@Test
	public void Scope비교() {
		//assertEquals(restaurant, restaurant1);
		assertThat(restaurant==restaurant1).isTrue();
	}
	
	
	//@Test
	public void test() {
		//System.out.println(restaurant);
		assertThat(restaurant.getChef()).isNotNull();
	}
}
