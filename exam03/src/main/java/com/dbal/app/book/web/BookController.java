package com.dbal.app.book.web;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.dbal.app.book.model.BookVO;
import com.dbal.app.book.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService service;
	
	//전체목록
	@RequestMapping("/list")
	public String getBookList(Model model) {	
		model.addAttribute("bookList", service.getBookList());
		return "book/list";
	}
	
	//등록
	@GetMapping("book/insert")
	public void insert() {}
	
	//등록기능
	@PostMapping("/insert")
	public String insert(BookVO vo) {
		service.insertBook(vo);
		return "redirect:/list";
	}
	
//	@PostMapping("/insert")
//	public String insert(BookVO vo, Model model) {
//		if(service.insertBook(vo) == 1) {
//			model.addAttribute("msg", "도서등록이 완료되었습니다");
//			return "alert";
//		}
//		return "redirect:/list";
//	}
	
	//대여목록
//	@GetMapping("/rentList")
//	public
	
	
}
