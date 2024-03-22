package com.sam.app.insa.mapper;

import java.util.List;

import com.sam.app.insa.service.DepartmentsVO;

public interface DepartmentsMapper {

	public List<DepartmentsVO> getDepartmentsList(DepartmentsVO vo);
	
}
