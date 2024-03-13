package com.example.demo.emp;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpVO {
	int employeeId; //integer면 null값인지 체크가능(참조타입이라)
	String firstName;
	String lastName;
	String email;
	Date hireDate;
	Integer salary;
	String jobId;
	String departmentId;
	String managerId;
	String phone;
	
	//mapper페이징처리로 추가
	int start = 1;
	int end = 10;
	
	int[] employeeIds;
}
