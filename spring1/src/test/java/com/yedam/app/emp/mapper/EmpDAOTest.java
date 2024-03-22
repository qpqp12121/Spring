package com.yedam.app.emp.mapper;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/*-context.xml")
public class EmpDAOTest {

	@Autowired
	EmpMapper empDAO;
	
	@Test
	public void getTime() {
		String employeeId = "100";
		Map<String,Object> map = empDAO.getInfo(employeeId);
		assertEquals(map.get("EMPLOYEE_ID").toString(), employeeId);
	}
	
}
