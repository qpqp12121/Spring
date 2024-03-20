package com.example.demo.customer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.customer.domain.Customer;
import com.example.demo.customer.repository.CustomerRepository;

@SpringBootTest
public class CustomerRepositoryTest {
	
	@Autowired
	CustomerRepository repo;
	
	@AfterEach
	public void cleanup() {
		repo.deleteAll();
	}
	
	
	@Test
	public void 저장_조회() {
		//given
		String name = "홍길동";
		String phone = "010-1111";
		
		Customer customer = Customer.builder()
									.name(name)
									.phone(phone)
									.build(); //.build()하면 객체생성
		
		repo.save(customer); //등록(insert구문 jpa가 자동생성)
		
		//when
		//List<Customer> list = repo.findAll(); //전체조회
		List<Customer> list = repo.findByNameLike(name); //필드명name으로 검색
	
		//then
		Customer result = list.get(0);
		assertThat(result.getName()).isEqualTo(name); //단위테스트 결과는 무조건 true/false가 나오게 하기 assert사용(?)
	}
}
