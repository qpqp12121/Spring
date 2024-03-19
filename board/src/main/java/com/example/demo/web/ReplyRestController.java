package com.example.demo.web;

import java.util.List;

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
import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.common.Paging;
import com.example.demo.emp.EmpVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor

public class ReplyRestController {
	//생성자 주입방식
	final ReplyMapper mapper;
	
//댓글리스트 페이지 이동
	@GetMapping("/replyMng")
	public ModelAndView replyMng() {
		ModelAndView mv = new ModelAndView("board/replyMng");
		return mv;
	}
//댓글리스트 데이터(해당 bno 커맨드 객체로 받기)-http://localhost:8082/reply/list?bno=1
	@GetMapping("/replyList")
	public List<ReplyVO> replyList(ReplyVO vo, BSearchVO svo, Paging pvo) {
		svo.setStart(pvo.getFirst());
		svo.setEnd(pvo.getLast());
		return mapper.getReplyList(vo, svo);
	}

//페이징 없는 uri파라미터로 받기
//	@GetMapping("/replyList/{bno}")
//	public List<ReplyVO> replyList(@PathVariable int bno) {
//		return mapper.getReplyList(bno);
//	}
	
//페이징없는 커맨드객체로 글번호 받음
//	@GetMapping("/replyList")
//	public List<ReplyVO> replyList(ReplyVO vo) {
//		return mapper.getReplyList(vo);
//	}

//상세조회
	@GetMapping("/reply/{rno}")
	public ReplyVO info(@PathVariable int rno) {
		return mapper.getReplyInfo(rno);
	}

	
	
//등록
	//JSON
	@PostMapping("/reply")
	public ReplyVO save(@RequestBody ReplyVO vo) { 
		System.out.println(vo); //콘솔창 테스트시 아래 막아놓고
		mapper.insertReply(vo);
		return vo;
	}
//삭제
	@GetMapping("/reply/del/{rno}")
	public int delete(@PathVariable int rno) {
		System.out.println("삭제된 댓글번호? " + rno);
		return mapper.deleteReply(rno);
	}
	
}
