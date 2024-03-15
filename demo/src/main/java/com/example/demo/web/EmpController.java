package com.example.demo.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.SearchVO;
import com.example.demo.emp.mapper.EmpMapper;

import lombok.RequiredArgsConstructor;

@Controller // 컨테이너 빈 등록 + 사용자요청처리 커맨드 핸들러 변환
@RequiredArgsConstructor //생성자주입

public class EmpController {
	
	//@Autowired EmpMapper dao; //의존성주입(DI dependency Injection) -- 객체관리를 스프링이 알아서 해 줌(new키워드 없이도 Autowired쓰면?)
	final EmpMapper mapper; //생성자주입

	//목록페이지로 이동
	@RequestMapping("/empList")
	public String empList(Model model, EmpVO vo, SearchVO svo){
		model.addAttribute("companyName", "<i><font color='red'>예담주식회사</font></i>");
		model.addAttribute("empList", mapper.getEmpList(vo, svo));
		return "empList"; 
	}
	
	//상세조회 페이지 이동
	@GetMapping("/emp/info/{employeeId}")
	public String empInfo(Model model, @PathVariable int employeeId) {
		model.addAttribute("emp", mapper.getEmpInfo(employeeId));
		return "emp/info";
	}
	
	
	//등록페이지 이동
	@GetMapping("/emp/insert")
	public void insert() { }
	
	//등록 처리 --> photo employees 테이블에 photo 컬럼 추가
	@PostMapping("/insert")
	public String insert(@ModelAttribute("emp") EmpVO vo, @RequestParam(name="photofile") MultipartFile photo) throws IllegalStateException, IOException {
		System.out.println(vo);                           //input name이랑 필드명이랑 같으면 XX 못 찾아감!!
		
		if(photo != null) {
			if(photo.getSize() > 0) {
				//파일생성
				String photoName = photo.getOriginalFilename();
				File file = new File("d:/upload", photo.getOriginalFilename());
				//파일저장
				photo.transferTo(file);//정보출력
				
				System.out.println("파일명: " + photo.getOriginalFilename());
				System.out.println("파일크기: " + photo.getSize());
				
				vo.setPhoto(photoName); //파일이름을 photo필드에 담아야 되니 set (자주쓰려면변수로선언해도되고)
				mapper.insertEmp(vo);
			}
		}
		return "redirect:/emp/list";
	}
	
	
	//수정페이지 이동
	/*
	 * @GetMapping("/emp/update") public void update() { }
	 */
	
	//수정처리
	@GetMapping("/update/{empId}")
	public String update(@PathVariable int empId) {
		System.out.println(empId);
		return "index";
	}
	
	
	//삭제처리
	@GetMapping("/delete")
	public String delete(int employeeId, String name) {
		System.out.println(employeeId + ": " + name);
		return "index";
	}
	

	

//	@RequestMapping("update")
//	@ResponseBody	     //request.getParameter랑 같음(아래)
//	public String update(@RequestParam List<String> hobby) {
//		System.out.println(hobby);
//		return "true";
//	}
//	
//	@RequestMapping("/ajaxEmp")
//	@ResponseBody
//	public List<EmpVO> ajaxEmp() {
//		return mapper.getEmpList(null,null);
//	}
//	

// req1 url로 테스트 (?)
//	@RequestMapping("insert")
//	@PostMapping("/insert")
//	@ResponseBody //--결과확인페이지 만들 때 주석처리함 (template에 result.html)
//	public EmpVO insert(EmpVO vo) {
//		System.out.println(vo);
//		mapper.insertEmp(vo);
//		return vo; //@ResponseBody 사용해서 return에 담아주는 건 데이터
//	}
	

	//template에 result.html
//	@PostMapping("/insert")
//	public String insert(@ModelAttribute("emp")EmpVO vo, Model model) { //(EmpVO vo, Model model) 기본 값
//		System.out.println(vo);
//		//커맨드객체는 자동으로 model에 추가되고 view페이지로 전달되어 사용가능
//		//model.addAttribute("empVO", vo) --(기본값)클래스의 이름 EmpVO의 제일 앞 글자만 소문자로 empVO로 result.html에 적으면 됨
//		//model.addAttribute("emp", vo) --@ModelAttribute("emp") 적어줬을 경우
//		//model.addAttribute("insertResult", "success"); //view페이지 가기 전에 결과 담는 게 model
//		return "result";
//	}
	
	
	//template에 result.html
//	@PostMapping("/insert")
//	public ModelAndView insert(@ModelAttribute("emp")EmpVO vo) {
//		System.out.println(vo);
//		
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("result");
//		mv.addObject("insertResult", "success");
//		mv.setStatus(HttpStatus.INTERNAL_SERVER_ERROR); //이렇게 상태값 넘길 거 아니면 굳이 ModelAndView 쓸 필요 x ?
//		return mv;
//	}
//	
//	@PostMapping("/insert2")
//	public ResponseEntity<EmpVO> insert2(EmpVO vo) {
//		return new ResponseEntity<>(vo, HttpStatus.OK);
//	}
//	
//	@RequestMapping("/empResult")
//	public String result() {
//		return "result";
//	}
//	
//	@PostMapping("/insert3")
//	public String insert3(EmpVO vo, RedirectAttributes rttr) {
//		System.out.println("등록: " + vo);
//		rttr.addAttribute("insertResult", "성공");
//		rttr.addFlashAttribute("flashResult", "한 번만 사용가능");
//		return "redirect:empResult"; //redirect:url주소
//	}
//	
//	
//	@GetMapping("/")
//	public String test() {
//		return "index";
//	}
//	
//
//	
//	@RequestMapping("/empList")
//	public String empList(Model model){
//		model.addAttribute("empList", mapper.getEmpList(null,null));
//		return "empList"; 
//	}
}
