package com.yedam.app.컬렉션;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.yedam.app.EmpVO;

public class 맵테스트 {
	public static void main(String[] args) {
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("100", "park");
		map.put("101", "kim");
		map.put("102", "choi");
		
		String name = (String)map.get("101");
		
		//Map에 반복문 사용(key값만 set으로 받아와 for문 사용할 수 있음) --Map 자체는 for문 사용 불가
		for(String key : map.keySet()) {
			System.out.println(key + ": " + map.get(key));
		}
		
		
		//vo 대신 == Map사용
		List<HashMap<String, Object>> empList = new ArrayList<HashMap<String, Object>>(); //값 여러타입 담으려면 Object로
		map = new HashMap<>();
		map.put("firstName", "park");
		map.put("lastName", "aaa");
		map.put("salary", 20000);
		empList.add(map);
		
		map = new HashMap<>();
		map.put("firstName", "choi");
		map.put("lastName", "bbb");
		map.put("salary", 10000);
		empList.add(map);
		
		//firstName만 출력
		for(HashMap<String, Object> empAmp : empList) {
			System.out.println(empAmp.get("firstName"));
		}
		
		//Q.급여가 15000이상인 사람만
		//1)filter 방식으로
		List<HashMap<String, Object>> filterList = new ArrayList<HashMap<String, Object>>();
		for(HashMap<String, Object> empAmp : empList) {
			if((int)empAmp.get("salary") >= 15000) {
				filterList.add(empAmp);
			}
		}
		System.out.println(filterList);
		
		//2)stream방식으로
		filterList = empList.stream().filter(empAmp -> (int)empAmp.get("salary") >= 15000)
					                 .collect(Collectors.toList()); 
		System.out.println(filterList);
		
		//새로운 list생성하여 담지 않고(생략) .peek(System.out :: println)으로 바로 출력 가능
		empList.stream().filter(empAmp -> (int)empAmp.get("salary") >= 15000)
					    .peek(System.out :: println)
					    .collect(Collectors.toList());
		
		
		
	}
}
