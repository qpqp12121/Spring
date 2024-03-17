package com.example.demo.emppractice;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data

public class EmpVO {

	int employeeId;
	String firstName;
	String lastName;
	String email;
	String phoneNumber;
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") //등록 시 테이블의 타입이랑 안 맞아서 막아 놓음
	Date hireDate;
	String jobId;
	Integer salary;
	String managerId;
	String departmentId;
	String photo = "없음";
	
	int[] employeeIds;
}
