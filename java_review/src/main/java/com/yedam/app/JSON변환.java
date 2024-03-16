package com.yedam.app;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//참고: https://www.baeldung.com/jackson-object-mapper-tutorial

public class JSON변환 {	
	public static void main(String[] args) throws MalformedURLException, IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		//1.Java Object to JSON
		EmpVO vo = new EmpVO("길동", "홍"); //생성자에 초기값 넣기
		
//		EmpVO vo = new EmpVO(); //setter 메소드로 값 setting
//		vo.setFirstName("길동");
//		vo.setLastName("홍");
		String str = objectMapper.writeValueAsString(vo);
		
		//2.JSON to Java Object
		String json = "{\"employeeId\":0,\"firstName\":\"길동\",\"lastName\":\"홍\",\"email\":null,\"hireDate\":null,\"salary\":null,\"jobId\":null,\"departmentId\":null,\"managerId\":null,\"phone\":null,\"photo\":null}\r\n"
				+ "";
		vo = objectMapper.readValue(json, EmpVO.class);
		
		//3.URL 사용해서 JSON to Java Object
		//https://jsonplaceholder.typicode.com/
		Map map = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/todos/1"), Map.class);
		System.out.println(map.get("title"));
		
		//Creating a Java List From a JSON Array String
		
		
	}

}
