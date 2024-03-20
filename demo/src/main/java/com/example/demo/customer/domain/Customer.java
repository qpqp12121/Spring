package com.example.demo.customer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//도메인에는 @Data 사용하지말기

@Getter
@Builder //생성자
@AllArgsConstructor //Builder랑 세트로 생각하면 됨  
@NoArgsConstructor//기본생성자
@Entity //entity 자체가 테이블과 연결 됨
public class Customer {
	
	//자동으로 Customer 테이블에 id라는 이름,데이터 타입으로 들어감 
	
	@Id //기본키로 설정
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id; 
	
	//컬럼 속성정하고 싶으면 @Column 사용
	@Column(length = 20, nullable = false)
	private String name;
	private String phone;	
	
}
