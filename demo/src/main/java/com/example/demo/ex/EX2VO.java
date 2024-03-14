package com.example.demo.ex;

import java.util.List;

import lombok.Data;

@Data
public class EX2VO {
	//필드명 input name이랑 같게
	private String username;
	private String password;
	private List<String> hobby; //String [] 이렇게 해도 됨 (checkbox 값 여러 개일 때)
}
