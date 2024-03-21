package com.example.demo.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.board.BSearchVO;
import com.example.demo.board.ReplyVO;
import com.example.demo.board.service.ReplyService;
import com.example.demo.common.Paging;
import com.example.demo.emp.EmpVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor

public class ReplyRestController {
	//생성자 주입방식
	final ReplyService service;
	
//댓글리스트 페이지 이동
	@GetMapping("/replyMng")
	public ModelAndView replyMng() {
		ModelAndView mv = new ModelAndView("board/replyMng");
		return mv;
	}
//댓글리스트 데이터(해당 bno 커맨드 객체로 받기)-http://localhost:8082/replyList?bno=1
	@GetMapping("/replyList")
	public Map<String,Object> replyList(ReplyVO vo, BSearchVO svo, Paging pvo) {
		
		svo.setStart(pvo.getFirst());
		svo.setEnd(pvo.getLast());
		
		Map<String,Object> map = service.getReplyList(vo, svo);
		pvo.setTotalRecord((int) map.get("count"));
		
		map.put("paging", pvo);
		
		return map;
	}


//상세조회
	@GetMapping("/reply/{rno}")
	public ReplyVO info(@PathVariable int rno) {
		return service.getReplyInfo(rno);
	}
	
//등록
	//JSON
	@PostMapping("/reply")
	public ReplyVO save(@RequestBody ReplyVO vo) { 
		System.out.println(vo); //콘솔창 테스트시 아래 막아놓고
		service.insertReply(vo);
		return vo;
	}

//수정
	@PostMapping("/reply/update")
	public ReplyVO update(ReplyVO vo) {
		service.updateReply(vo);
		return vo;
	}
	
	
//삭제
	@GetMapping("/reply/del/{rno}")
	public int delete(@PathVariable int rno) {
		System.out.println("삭제된 댓글번호? " + rno);
		return service.deleteReply(rno);
	}
	
}
