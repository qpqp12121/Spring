package com.example.demo.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Component //bean등록 -- 꺼내쓰는 게 @Autowired (DITest참고)
@Data
@RequiredArgsConstructor //Autowired/Setter보다 이 방식 더 선호

//@Scope //singleton(기본-한번 생성되면 계속 불러다 씀)
@Scope("prototype")//prototype(Autowired할 때마다 새로 객체 생성 됨), request, session

public class Restaurant {
	//@Autowired
	//@Setter(onMethod_ = {@Autowired})
	final private Chef chef;

//	public Restaurant(Chef chef) { //생성자 -- 롬복 사용하면 private Chef chef 필드 앞에 final 적고 @RequiredArgsConstructor 작성하면 생성자 직접 적지 않고 만들어 줌
//		this.chef = chef;
//	}

	

}
