package com.example.demo.emp;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class EmpVO {
	int employeeId; //int는 null값 체크 X
	String firstName;
	String lastName;
	String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	Date hireDate; //위처럼 포맷 안 정했을 땐 2024/03/14 이렇게 넣어야 나왔음
	Integer salary; //integer면 null값인지 체크가능(참조타입이라)
	String jobId;
	String departmentId;
	String managerId;
	String phone;
	String photo;
	
	//mapper페이징처리로 추가
	int start = 1;
	int end = 10;
	
	int[] employeeIds;
}
