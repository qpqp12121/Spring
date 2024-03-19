package com.example.demo.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.common.Paging;
import com.example.demo.emp.EmpVO;
import com.example.demo.emp.SearchVO;
import com.example.demo.emp.mapper.EmpMapper;
import com.example.demo.emp.service.EmpService;

//@Controller //아래 @ResponseBody 함께 써줘야 됨
@RestController //쓰면 아래 @ResponseBody 필요 없음
public class EmpRestController {
	//@Autowired EmpMapper mapper;
	@Autowired EmpService service;
	
// 1.@Controller랑 @ResponseBody 같이 사용하는 경우
	//리스트 페이지 이동
//	@GetMapping("/empMng")
//	public void empMng() { } //ajax는 페이지이동 따로 (데이터가지고 X)
		
	//사원 리스트 데이터
//	@GetMapping("/ajax/empList")//ajax응답은 model 필요 X
//	@ResponseBody //vo객체를 -> json string 형식으로 변환시켜 줌 (ajax응답이라는 걸 알려주기)
//	public List<EmpVO> empList(EmpVO vo, SearchVO svo, Paging pvo) { //페이지응답은 return타입 "페이지명"이라 무조건 public String 메서드명(){}인데 ajax응답은 return 데이터에 맞게 설정	
//		svo.setStart(pvo.getFirst());
//		svo.setEnd(pvo.getLast());
//		return mapper.getEmpList(vo, svo);
//	}

// 2.@RestController 하나로 통합하여 사용 (리스트 페이지 ModelAndView타입으로 해야 뷰 페이지로 이동)
	//리스트페이지 이동
	@GetMapping("/empMng")
	public ModelAndView empMng() {  //ajax는 페이지이동 따로 (데이터가지고 X)
		ModelAndView mv = new ModelAndView("empMng");
		return mv;
	}
	//사원리스트 데이터
	@GetMapping("/ajax/empList")//ajax응답은 model 필요 X
	public Map<String,Object> empList(EmpVO vo, SearchVO svo, Paging pvo) { //페이지응답은 return타입 "페이지명"이라 무조건 public String 메서드명(){}인데 ajax응답은 return 데이터에 맞게 설정	
		svo.setStart(pvo.getFirst());
		svo.setEnd(pvo.getLast());
		Map<String,Object> map = service.getEmpList(vo, svo);
		pvo.setTotalRecord((Long)map.get("count"));
		map.put("paging", pvo);
		
		return map; //EmpController에선 model.add안해도넘어갔는데 ajax는 X=> return한 거만 넘어감
	}
	
//================================================================	
	//사원등록
	//1.queryString으로 먼저 , 2.formData
//	@PostMapping("/ajax/emp")
//	public EmpVO save(EmpVO vo) { 
//		System.out.println(vo); //콘솔창 테스트시 아래 막아놓고
//		//mapper.insertEmp(vo);
//		return vo;
//	}
	
	//3.JSON
	@PostMapping("/ajax/emp")
	public EmpVO save(@RequestBody EmpVO vo) { 
		System.out.println(vo); //콘솔창 테스트시 아래 막아놓고
		service.insertEmp(vo);
		return vo;
	}

//=================================================================
	//단건조회
	@GetMapping("/ajax/emp/{employeeId}")
	public EmpVO info(@PathVariable int employeeId) { 
		return service.getEmpInfo(employeeId);
	}
//==================================================================
	//Chart
	//데이터로 empStat.html에 Chart로 만들거임
	@GetMapping("/ajax/empStat")
	public List<Map<String, Object>> stat() {
		return service.getStat();
	}
}
