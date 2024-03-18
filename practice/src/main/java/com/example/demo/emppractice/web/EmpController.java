package com.example.demo.emppractice.web;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.emppractice.EmpVO;
import com.example.demo.emppractice.SearchVO;
import com.example.demo.emppractice.mapper.EmpMapper;

import lombok.RequiredArgsConstructor;

@Controller //container에 bean 등록 + 사용자 요청처리 커맨드 핸들러 변환
@RequiredArgsConstructor //생성자 주입방식 롬복 기능
@RequestMapping(value = "/emp") //공통 url로 설정 (localhost:8081/emp) //RequestMapping은 클래스&메서드에 다 적용가능 (@GetMapping, Post등등은 메서드에만)


public class EmpController {

	//생성자 주입방식
	final EmpMapper mapper;
	
	
	//전체목록
	@GetMapping("/list")
	public String empList(Model model) {
		//Model객체: Controller에서 생성된 데이터를 View로 전달할 때 사용하는 객체
		//전달 방법이 model.addAttribute("key", "value")
		model.addAttribute("empList", mapper.getEmpList()); //= req.setAttribute("boardList", list); => jsp파일에서 ${boardList}로 값 읽음
															//요청정보에 실어줌 [ 요소.setAttribute("key", value담은 변수): 선택한 요소에 값 담기 ]
		return "emp/list"; //html파일 경로와 이름 주의! (template아래 emp폴더 안의 list.html파일)
	}
	
	//전체목록 페이징&동적쿼리 적용
	@GetMapping("/listPaging")
	public String empPaging(Model model, EmpVO vo, SearchVO svo) {
		model.addAttribute("empList", mapper.getEmpPaging(vo, svo));
		return "emp/listPaging";
	}
	
//========================================================================
	/* 컨트롤러에서 HTTP 요청 파라미터 받기 */
	//단건조회
	
	//1.URI에 전달되는 파라미터 받기 ( http://localhost/emp/info/100 )
	@GetMapping("/info/{employeeId}")
	public String empInfo(Model model, @PathVariable int employeeId) {
		model.addAttribute("empInfo", mapper.getEmpInfo(employeeId));
		return "emp/info";
	}
	
	
	//2.질의문자열을 커맨드 객체로 받기 ( http://localhost:8081/emp/info?employeeId=100 )
	@RequestMapping("/info") //@GetMapping해도 됨(위에도 다 마찬가지)
	public String empInfo(Model model, EmpVO vo) {
		model.addAttribute("empInfo", mapper.getEmpInfo(vo));
		return "emp/info";
	}
	
	//3.질의문자열 파라미터 받기 ( http://localhost:8081/emp/info?employeeId=100 )
//	@GetMapping("/info")
//	public String empInfo(Model model, int employeeId) { //@RequestParam으로 required=true 등으로 조건 작성 가능 (required=false가 기본값)
//		model.addAttribute("empInfo", mapper.getEmpInfo(employeeId));
//		return "emp/info";
//	}
	
//======================================================================
	
	//등록페이지 이동
	@GetMapping("/insert")
	public void insert() {}
	
	//등록 처리 (첨부파일 포함)
	@PostMapping("/insert")
	public String insert(EmpVO vo, MultipartFile photofile) throws IllegalStateException, IOException {
		
		if(photofile != null) {
			//파일생성
			File file = new File("c:/upload", photofile.getOriginalFilename());
			//파일저장
			photofile.transferTo(file); //예외처리
			
			System.out.println("파일명: " + photofile.getOriginalFilename());
			System.out.println("파일크기: " + photofile.getSize());
			
			//파일이름 photo필드에 담기
			vo.setPhoto(photofile.getOriginalFilename());
			mapper.insertEmp(vo);
		}
		return "redirect:/emp/list";
	}
	
	
	//수정페이지 이동
	@GetMapping("/update/{employeeId}")
	public String empUpdate(Model model, @PathVariable int employeeId) {
		model.addAttribute("emp", mapper.getEmpInfo(employeeId));
		return "emp/update";
	}
	
	//수정 처리
	@PostMapping("/update")
	public String update(EmpVO vo, MultipartFile photofile) throws IllegalStateException, IOException {
			
			if(photofile != null) {
				//파일생성
				File file = new File("c:/upload", photofile.getOriginalFilename());
				//파일저장
				photofile.transferTo(file); //예외처리
				
				System.out.println("파일명: " + photofile.getOriginalFilename());
				System.out.println("파일크기: " + photofile.getSize());
				
				//파일이름 photo필드에 담기
				vo.setPhoto(photofile.getOriginalFilename());
				mapper.updateEmp(vo);
			}			
			return "redirect:/emp/list";
		}

	
	//삭제
	@GetMapping("/delete")
	public String delete(int employeeId) {
		System.out.println("삭제된 사원번호는? " + employeeId);
		mapper.deleteEmp(employeeId);
		return "redirect:/emp/list";
	}
	
	
	
}
