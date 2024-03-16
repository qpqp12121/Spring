package com.yedam.app.컬렉션;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.yedam.app.EmpVO;

/* < List / Set / Map >
  
  - List: index로 접근    => 순차적 목록
  - Set: index로 접근     -> 중복값 허용 X 
  - Map: <k,v> key로 접근 => 검색 빠름
  
*/
public class CollectionTest {
	public static void main(String[] args) {
		
		//중복값 제거
		List<Integer> list = Arrays.asList(3, 3, 10, 11, 14, 3); //배열값을 리스트로 바꿔 줌
		System.out.println(list);
		
		//list 중복값 없애서 출력 => Set에 담기
		HashSet set = new HashSet<>(list);  //LinkedHashSet (Linked- 가 붙으면 입력,삭제가 많을 때 사용추천)
		Set<Integer> set2 = new HashSet<>(list);
		System.out.println(set2);
		
		//List<EmpVO> 비교
		List<EmpVO> empList = new ArrayList<>();
		empList.add(new EmpVO("choi", "aaa", 20000));
		empList.add(new EmpVO("kim", "abc", 10000));
		empList.add(new EmpVO("park", "bbb", 14000));
		empList.add(new EmpVO("park", "bbb", 20000));
		
		//중복값 제거
		HashSet<EmpVO> empSet = new HashSet<>(empList);
		System.out.println(empSet.size());
		
		for(EmpVO emp : empSet) {
			System.out.println(emp.getFirstName()+ "_" + emp.getLastName() + ": " + emp.getSalary());;
		}
		
		/* < filter > */
		//Q.급여가 15000이상인 사원만 검색
		//1번 방식
		List<EmpVO> filterList = new ArrayList<>(); //필터된 값 담을 리스트 생성
		for(EmpVO vo : empSet) {
			if(vo.getSalary() >= 15000) {
				filterList.add(vo);
			}
		}
		System.out.println(filterList.size());
		
		
		//2번 stream방식으로 (java8부터 가능)
		filterList = empSet.stream().filter( vo -> vo.getSalary() >= 15000) //filter(받는 값 -> 넘겨줄 식)
						   .collect(Collectors.toList()); //filter된 값을 모아서 filterList에 대입
		//System.out.println(filterList); 
		
		
		//Q.lastName이 bbb인 사람만
		List<EmpVO> filterLastName = new ArrayList<>();
		filterLastName = empSet.stream().filter( vo -> vo.getLastName().contains("b")) //.equals / .startsWith
										.collect(Collectors.toList());
		System.out.println(filterLastName);
		
		
		
		
	}//end of main.
}//end of class.
