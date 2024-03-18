package com.example.demo.emp_practice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.emppractice.EmpVO;
import com.example.demo.emppractice.SearchVO;

@Mapper

//sql쿼리문 호출하기 위한 인터페이스
public interface EmpMapper { //구현클래스가 xml파일
	
	//전체조회
	List<EmpVO> getEmpList();
	//전체조회 페이징&동적쿼리 추가
	List<EmpVO> getEmpPaging(@ModelAttribute("emp") EmpVO vo, SearchVO svo);
	
	//단건조회
	EmpVO getEmpInfo(int employeeId); //URI에 전달되는 파라미터로 받기 & 질의문자열 파라미터 받기
	EmpVO getEmpInfo(EmpVO vo); //질의문자열을 커맨드 객체로 받기
	
	//등록
	int insertEmp(EmpVO empVO); //insert returnType 2가지( int, void )
	
	//수정
	int updateEmp(EmpVO empVO);
	
	//삭제
	int deleteEmp(int employeeId);
	
}
