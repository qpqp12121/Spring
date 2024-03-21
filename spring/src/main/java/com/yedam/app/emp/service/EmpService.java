package com.yedam.app.emp.service;

import java.util.Map;


public interface EmpService {
	public String getTime();
	
	public Map<String,Object> getInfo(String employeeId);
	
}
