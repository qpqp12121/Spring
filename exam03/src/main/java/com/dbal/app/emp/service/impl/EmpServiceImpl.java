package com.dbal.app.emp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbal.app.emp.mapper.EmpMapper;
import com.dbal.app.emp.model.EmpVO;
import com.dbal.app.emp.service.EmpService;


@Service
public class EmpServiceImpl implements EmpService {

	@Autowired EmpMapper empDAO;
	
	@Override
	public EmpVO getEmp(EmpVO empVO) {
		return empDAO.getEmp(empVO);
	}


}
