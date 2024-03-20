package com.example.demo.web;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.board.BSearchVO;
import com.example.demo.board.BoardVO;
import com.example.demo.board.service.BoardService;
import com.example.demo.common.Paging;

import lombok.RequiredArgsConstructor;

@Controller //container에 bean 등록 + 사용자 요청처리 커맨드 핸들러 변환
@RequiredArgsConstructor //생성자 주입방식 롬복 기능
@RequestMapping(value = "/board") //공통 url로 설정 (localhost:8081/board) //RequestMapping은 클래스&메서드에 다 적용가능 (@GetMapping, Post등등은 메서드에만)


public class BoardController {

	//생성자 주입방식
	final BoardService service;
	
	
	//전체목록
	@GetMapping("/list") // /board/list
	public String boardList(Model model, BoardVO bvo, BSearchVO svo, Paging pvo) {
		//페이징
		pvo.setPageUnit(5); //한 페이지에 보여주는 데이터 건수
		pvo.setPageSize(3); //페이지 수
		
		svo.setStart(pvo.getFirst());
		svo.setEnd(pvo.getLast());
		
		Map<String,Object> map = service.getBoardList(bvo, svo);
		//전체건수
		pvo.setTotalRecord((Integer)map.get("count"));
		
		//목록데이터
		model.addAttribute("boardList", map.get("data"));
		 
		return "board/list";
	}
	
	
	//단건조회
	//URI에 전달되는 파라미터 받기
	@GetMapping("/info/{boardNo}")
	public String empInfo(Model model, @PathVariable int boardNo) {
		model.addAttribute("boardInfo", service.getBoardInfo(boardNo));
		return "board/info";
	}

	//등록페이지 이동
	@GetMapping("/insert")
	public void insert() {}
	
	//등록 처리 (첨부파일 포함)
	@PostMapping("/insert")
	public String insert(BoardVO bvo, MultipartFile imagefile) throws IllegalStateException, IOException {
		
		if(imagefile != null) {
			//파일생성
			File file = new File("c:/upload", imagefile.getOriginalFilename());
			//파일저장
			imagefile.transferTo(file); //예외처리
			
			System.out.println("파일명: " + imagefile.getOriginalFilename());
			System.out.println("파일크기: " + imagefile.getSize());
			
			//파일이름 photo필드에 담기
			bvo.setImage(imagefile.getOriginalFilename());
			service.insertBoard(bvo);
		}
		return "redirect:/board/list";
	}

	
	
	//수정페이지 이동
	@GetMapping("/update/{boardNo}")
	public String empUpdate(Model model, @PathVariable int boardNo) {
		model.addAttribute("board", service.getBoardInfo(boardNo));
		return "board/update";
	}
	
	//수정 처리
	@PostMapping("/update")
	public String update(BoardVO bvo) {
		service.updateBoard(bvo);
		return "redirect:/board/list";
	}
//	@PostMapping("/update")
//	public String update(BoardVO bvo, MultipartFile imagefile) throws IllegalStateException, IOException {
//			
//			if(imagefile != null) {
//				//파일생성
//				File file = new File("c:/upload", imagefile.getOriginalFilename());
//				//파일저장
//				imagefile.transferTo(file); //예외처리
//				
//				System.out.println("파일명: " + imagefile.getOriginalFilename());
//				System.out.println("파일크기: " + imagefile.getSize());
//				
//				//파일이름 photo필드에 담기
//				bvo.setImage(imagefile.getOriginalFilename());
//				service.updateBoard(bvo);
//			}
//			return "redirect:/board/list";
//		}


	
	//삭제
	@GetMapping("/delete")
	public String delete(int boardNo) {
		service.deleteBoard(boardNo);
		return "redirect:/board/list";
	}
	
	
	
}
