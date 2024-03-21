package com.example.demo.board.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.board.BSearchVO;
import com.example.demo.board.ReplyVO;
import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.ReplyService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	
	final ReplyMapper mapper;
	
	//댓글목록&페이징
	@Override
	public Map<String, Object> getReplyList(ReplyVO vo, BSearchVO svo) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("count", mapper.getCount(vo, svo));
		map.put("list", mapper.getReplyList(vo, svo));

		return map;
	}

	//상세조회
	@Override
	public ReplyVO getReplyInfo(int rno) {
		return mapper.getReplyInfo(rno);
	}

	//등록
	@Override
	public int insertReply(ReplyVO vo) {
		return mapper.insertReply(vo);
	}

	//수정
	@Override
	public int updateReply(ReplyVO vo) {
		return mapper.updateReply(vo);
	}
	
	
	//삭제
	@Override
	public int deleteReply(int rno) {
		return mapper.deleteReply(rno);
	}


	
	
}
