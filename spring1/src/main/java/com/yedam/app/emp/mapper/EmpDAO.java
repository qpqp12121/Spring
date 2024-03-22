package com.yedam.app.emp.mapper;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Repository
public class EmpDAO {
	
	@Autowired
	SqlSession mybatis;
	
	public void setMybatis(SqlSession mybatis) {
		this.mybatis = mybatis;
	}
	
	public Map<String,Object> getInfo(String employeeId) {
		return mybatis.selectOne("Employee.getInfo", employeeId);
	}
	
}
