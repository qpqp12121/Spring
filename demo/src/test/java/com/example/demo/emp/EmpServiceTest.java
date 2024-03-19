package com.example.demo.emp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.emp.service.EmpService;

@SpringBootTest
public class EmpServiceTest {

	@Autowired EmpService empService; //X EmpServiceImpl(구현클래스)를 지정할 필요없이 인터페이스만 적어주면 알아서 구현클래스 찾아서 처리함

	@Test
	public void 리스트페이지조회() {
		//< Test 3단계 >
		//given (테스트할 때 필요한 값)
		EmpVO evo = new EmpVO();
		SearchVO svo = new SearchVO();
		svo.setStart(1);
		svo.setEnd(10);
		
		//when
		Map<String,Object> map = empService.getEmpList(evo, svo); 
		
		//then (테스트 결과) - assert 사용해서 true/false로 확인
		System.out.println(map.get("count")); //(sysout은 편의상 쓴 거임)
//		assertThat(map.get("data")).isNotNull();
		assertThat(map.get("count")).isNotEqualTo(0); // 0이 아니면 true /0이면 test error뜨는 거 맞음
	
	}

	
}//end of class.
