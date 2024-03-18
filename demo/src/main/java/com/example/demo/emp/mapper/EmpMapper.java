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
	
	//수정
	
	//삭제
	int deleteEmp(int employeeId);
	
	//부서별 사원 수
	List<Map<String, Object>> getStat(); //부서별 인원수 조회
	
	
	//@Select("SELECT COUNT(*) FROM employees") //쿼리문 따로 작성 안하고 이렇게도 가능
	public long getCount(EmpVO vo, SearchVO svo); //count에도 조건절 걸어놔서 empvo, searchvo 다 넘겨줘야 됨 아니면 getproperty오류
	
}
