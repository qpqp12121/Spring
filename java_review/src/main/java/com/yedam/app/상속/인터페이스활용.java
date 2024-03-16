package com.yedam.app.상속;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.yedam.app.EmpVO;

public class 인터페이스활용 {
	public static void main(String[] args) {
		
		List<EmpVO> list = new ArrayList<>();
//		list.add(new EmpVO("choi", "aaa"));
//		list.add(new EmpVO("kim", "abc"));
//		list.add(new EmpVO("park", "bbb"));
		
		//급여까지(VO에 생성자 정의하기)
		list.add(new EmpVO("choi", "aaa", 20000));
		list.add(new EmpVO("kim", "abc", 10000));
		list.add(new EmpVO("park", "bbb", 14000));
		

		/* < sort > */
//		Collections.sort(list, new Comparator<EmpVO>() { //두번째 인수로 인터페이스 상속받은 구현클래스 와야 됨
//			
//			@Override
//			public int compare(EmpVO o1, EmpVO o2) {
//				return o1.getFirstName().compareTo(o2.getFirstName()); //비교식 가지고 위의 sort함수가 비교
//			}
//	
//		});
		
		//위 방식 더 간단하게 람다식 사용 (람다식 사용할 수 있는 경우? 익명클래스인 경우에 표현 가능. 조건은? 구현해야 될 (오버라이딩해야되는)메서드가 하나 뿐일 때
//		Collections.sort(list, (EmpVO o1, EmpVO o2) -> o1.getFirstName().compareTo(o2.getFirstName())); --문자열은 compareTo()로 비교
//		                                             //o2.getFirstName().compareTo(o1.getFirstName())) -- 역순
//		
		//급여비교
		Collections.sort(list, (EmpVO o1, EmpVO o2) -> o1.getSalary() - o2.getSalary()); //결과가 0이면 같고 / 양수면 앞에가 크고 (=> 부등호로 비교 X )

		for(EmpVO vo:list) {
			System.out.println(vo.getFirstName() + "_" + vo.getLastName() + ": "+ vo.getSalary());
		}	
	}
}

//class EmpCompare implements Comparator<EmpVO> {
//
//	
//	
//}