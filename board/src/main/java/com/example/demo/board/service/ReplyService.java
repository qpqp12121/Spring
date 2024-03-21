package com.example.demo.board.service;

import java.util.Map;

import com.example.demo.board.BSearchVO;
import com.example.demo.board.ReplyVO;

/* 사용자 요청에 의한 로직만 */

public interface ReplyService {

	//전체조회 페이징처리 추가 (list,전체건수 같이 넘기기 위해 ServiceImpl에서 Map으로 처리해야 되어 타입 변경)
	Map<String,Object> getReplyList(ReplyVO vo, BSearchVO svo);

	//상세조회
	ReplyVO getReplyInfo(int rno);
	
	//등록
	int insertReply(ReplyVO vo);
	
	//수정
	int updateReply(ReplyVO vo);
	
	//삭제
	int deleteReply(int rno);
	
}
