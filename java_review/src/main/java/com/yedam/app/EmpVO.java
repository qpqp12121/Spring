package com.yedam.app;

import java.util.Date;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor //final 붙어있는 필드 가지고 롬복이 생성자 알아서 생성해 줌(아래 생성자 정의했던 걸)
//@ToString
public class EmpVO {

	private int employeeId; //int는 null값 체크 X
//	private String firstName;
//	private String lastName;
	final private String firstName; //final은 한번 생성되면 변경 불가니 1)처음에 초기값을 바로 주거나 ex.final private String firstName=값
	final private String lastName; // 2)생성할 때 값 넣어줘야 됨 (위 @Require- 어노테이션으로 생성자 주입 방식 사용)
	
	private String email;
	private Date hireDate; //위처럼 포맷 안 정했을 땐 2024/03/14 이렇게 넣어야 나왔음
	private Integer salary; //integer면 null값인지 체크가능(참조타입이라)
	private String jobId;
	private String departmentId;
	private String managerId;
	private String phone;
	private String photo;
	
	
	//기본 생성자
//	public EmpVO() {
//		
//	}
	
	//생성자 정의
	//firstName, lastName은 롬복 기능 사용해서 생성자 만듦 ( @RequiredArgsConstructor쓰고 필드명 앞에 final 붙이기 )
	
	//급여까지
	public EmpVO(String firstName, String lastName, Integer salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}
	
	//getter
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public int getSalary() { //필드 Integer라도 int로 적으면 알아서 인식 (Integer해도 되고)
		return this.salary;
	}
	
	//setter
	
	//equlas
	@Override
	public boolean equals(Object obj) {
		EmpVO vo = (EmpVO) obj; //(obj 캐스팅) *부모 자식간의 형변환 가능
		return this.firstName.equals(vo.getFirstName()) 
				&& this.lastName.equals(vo.getLastName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.firstName, this.lastName); //firstName과 lastName 비교해서 담음
	}

	@Override
	public String toString() {
		return "firstName? " + firstName + ", lastName? " + lastName + ", salary? " + salary + "\n";
	}
	
	
}
