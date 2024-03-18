package com.example.demo.web;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.board.ReplyVO;
import com.example.demo.board.mapper.ReplyMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor

public class ReplyController {
	
	//생성자 주입방식
	final ReplyMapper mapper;
	
	//댓글리스트 페이지 이동
	@GetMapping("/replyMng")
	public ModelAndView replyMng() {
		ModelAndView mv = new ModelAndView("board/replyMng");
		return mv;
	}
	//리스트 데이터
	@GetMapping("/ajax/replyList")
	public List<ReplyVO> replyList() {
		return mapper.getReplyList();
	}
	
}
