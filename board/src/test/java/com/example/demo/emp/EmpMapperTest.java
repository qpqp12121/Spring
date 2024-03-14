package com.example.demo.emp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.emp.mapper.EmpMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@SpringBootTest //단위테스트
public class EmpMapperTest {

	@Autowired EmpMapper mapper; //mapper 사용시 선언
	//@Test	
	//페이징처리함
	public void 사원전체조회() {
		EmpVO vo = new EmpVO();
		SearchVO svo = new SearchVO();
//		vo.setDepartmentId("50");
//		vo.setFirstName("Kevin");
//		vo.setManagerId("103");
//		vo.setStart(1);
//		vo.setEnd(100);

		svo.setEmployeeIds(new int[] {100,101,102});
		
		List<EmpVO> list = mapper.getEmpList(vo, svo);
		
		System.out.println("결과는? " + list.size() +"건"); // list.size()로 건수만 확인해 봄
		//for문으로 employeeId, firstName만 출력
		
		//방법1)
		for(EmpVO emp : list) {			
			System.out.println("사원번호: " + emp.getEmployeeId() + ", " + emp.getFirstName());
		}
		
		//방법2)
//		for(int i=0; i < list.size(); i++) {
//			System.out.println(list.get(i).getEmployeeId() + ": " + list.get(i).getFirstName());
//		}
		
	}
	
	//@Test
	public void 사원단건조회() {
		int employeeId = 100;
		EmpVO vo = mapper.getEmpInfo(employeeId); //employeeId변수
		System.out.println(vo);
//		assertEqual(employeeId, vo.getEmployeeId());
	
	}
	
//	@Test
//	public void 사원등록() {
//		//vo객체 생성
//		EmpVO vo = new EmpVO();
//		vo.setEmployeeId(207);
//		vo.setFirstName("Park");
//		vo.setLastName("Jeong");
//		vo.setEmail("je@naver.com");
//		vo.setHireDate(new Date(2024,3,13));
//		vo.setJobId("IT_PROG");
////		vo.setManagerId("100"); //위까지만 Not Null이라 이 부분들은 안 적어도 됨
////		vo.setDepartmentId("60");
//		
//		//값을 담고
//		int result = mapper.insertEmp(vo);
//		System.out.println("등록건소: " + result);
//	}


	
/* 위 내용 lombok의 builder 기능 사용하기 
   EmpVO파일에 @Builder @NoArgsConstructor @AllArgsConstructor 적고 */
	@Test
	public void 사원등록() {
		//vo객체 생성 
		EmpVO vo = EmpVO.builder()
				   //.employeeId(301)
				   .firstName("aaa")
				   .lastName("bbb")
				   .email("ㅇㅇㅇ@naver.com")
				   .hireDate(new Date())
				   .jobId("IT_PROG")
				   .build();
		//값을 담고
		int result = mapper.insertEmp(vo);
		
		//시퀀스로 등록된 사번 조회
		System.out.println("등록된 사번: " + vo.getEmployeeId());
		System.out.println("등록건수: " + result);
	}	
	
//	@Test
//	public void 사원삭제() {
//		int empid = 207;
//		int result = mapper.deleteEmp(empid);
//		System.out.println(result);
//	}
	
//	@Test
//	public void 사원통계() {
//		List<Map<String, Object>> list = mapper.getStat();
//		System.out.println(list);
//		
//		//departmentId cnt만 출력
//		for(Map<String, Object> map : list) {
//			System.out.println(map.get("DEPARTMENT_ID")+ ". " +  map.get("name") + " (" + map.get("cnt") + "명)"); //map.get("key명")
//		}
//	}

	


	
}//End of Class.
