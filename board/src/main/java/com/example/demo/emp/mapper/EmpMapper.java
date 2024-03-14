package com.example.demo.emp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.SearchVO;

@Mapper
public interface EmpMapper {
	//전체조회
    //List<EmpVO> getEmpList();
	//전체조회 페이징처리 추가
	List<EmpVO> getEmpList(@Param("vo") EmpVO vo, SearchVO svo);
	
	//단건조회
	EmpVO getEmpInfo(int employeeId);
	
	//등록
	int insertEmp(EmpVO empVO); //insert returnType 2가지( int, void )
	
	//삭제
	int deleteEmp(int employeeId);
	
	//부서별 사원 수
	List<Map<String, Object>> getStat(); //부서별 인원수 조회
	
}
