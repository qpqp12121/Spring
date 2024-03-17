package com.example.demo.web;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.board.BSearchVO;
import com.example.demo.board.BoardVO;
import com.example.demo.board.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@Controller //container에 bean 등록 + 사용자 요청처리 커맨드 핸들러 변환
@RequiredArgsConstructor //생성자 주입방식 롬복 기능
@RequestMapping(value = "/board") //공통 url로 설정 (localhost:8081/board) //RequestMapping은 클래스&메서드에 다 적용가능 (@GetMapping, Post등등은 메서드에만)


public class BoardController {

	//생성자 주입방식
	final BoardMapper mapper;
	
	
	//전체목록
	@GetMapping("/list")
	public String boardList(Model model, BoardVO vo, BSearchVO svo) {
		model.addAttribute("boardList", mapper.getBoardList(vo, svo)); 
		return "board/list"; 
	}
	
	
	//단건조회
	
//	//1.URI에 전달되는 파라미터 받기 ( http://localhost/emp/info/100 )
//	@GetMapping("/info/{employeeId}")
//	public String empInfo(Model model, @PathVariable int employeeId) {
//		model.addAttribute("empInfo", mapper.getEmpInfo(employeeId));
//		return "emp/info";
//	}
//	
//	
//	//등록페이지 이동
//	@GetMapping("/insert")
//	public void insert() {}
//	
//	//등록 처리 (첨부파일 포함)
//	@PostMapping("/insert")
//	public String insert(EmpVO vo, MultipartFile photofile) throws IllegalStateException, IOException {
//		
//		if(photofile != null) {
//			//파일생성
//			File file = new File("c:/upload", photofile.getOriginalFilename());
//			//파일저장
//			photofile.transferTo(file); //예외처리
//			
//			System.out.println("파일명: " + photofile.getOriginalFilename());
//			System.out.println("파일크기: " + photofile.getSize());
//			
//			//파일이름 photo필드에 담기
//			vo.setPhoto(photofile.getOriginalFilename());
//			mapper.insertEmp(vo);
//		}
//		return "redirect:/emp/list";
//	}
//	
//	
//	//수정페이지 이동
//	@GetMapping("/update/{employeeId}")
//	public String empUpdate(Model model, @PathVariable int employeeId) {
//		model.addAttribute("emp", mapper.getEmpInfo(employeeId));
//		return "emp/update";
//	}
//	
//	//수정 처리
//	@PostMapping("/update")
//	public String update(EmpVO vo, MultipartFile photofile) throws IllegalStateException, IOException {
//			
//			if(photofile != null) {
//				//파일생성
//				File file = new File("c:/upload", photofile.getOriginalFilename());
//				//파일저장
//				photofile.transferTo(file); //예외처리
//				
//				System.out.println("파일명: " + photofile.getOriginalFilename());
//				System.out.println("파일크기: " + photofile.getSize());
//				
//				//파일이름 photo필드에 담기
//				vo.setPhoto(photofile.getOriginalFilename());
//				mapper.updateEmp(vo);
//			}			
//			return "redirect:/emp/list";
//		}
//
//	
//	//삭제
//	@GetMapping("/delete")
//	public String delete(int employeeId) {
//		System.out.println("삭제된 사원번호는? " + employeeId);
//		mapper.deleteEmp(employeeId);
//		return "redirect:/emp/list";
//	}
	
	
	
}
