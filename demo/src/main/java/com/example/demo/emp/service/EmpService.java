package com.example.demo.emp.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.SearchVO;

/* 사용자 요청에 의한 로직만 */

public interface EmpService {

	//전체조회 페이징처리 추가 (list,전체건수 같이 넘기기 위해 ServiceImpl에서 Map으로 처리하려 변경)
	Map<String, Object> getEmpList(@Param("vo") EmpVO vo, SearchVO svo);
	
	//단건조회
	EmpVO getEmpInfo(int employeeId);
	
	//등록
	int insertEmp(EmpVO empVO); //insert returnType 2가지( int, void )
	
	//수정
	
	//삭제
	int deleteEmp(int employeeId);
	
	//부서별 사원 수
	List<Map<String, Object>> getStat(); //부서별 인원수 조회
	
	
	//*건수는 사용자가 요청할 일이 없으니 서비스엔 등록 XX (페이징위한것이지)
	//전체조회할 때 리스트와 함께 map에 담아서 데이터 보내는 걸로 처리
	//public long getCount(EmpVO vo, SearchVO svo);
	
}
