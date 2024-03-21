package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.BSearchVO;
import com.example.demo.board.ReplyVO;

@Mapper
public interface ReplyMapper {

	//해당게시글 댓글조회(+페이징) --질의문자열 커맨드객체로 받기
	List<ReplyVO> getReplyList(ReplyVO vo, BSearchVO svo);
	int getCount(ReplyVO vo, BSearchVO svo); //전체건수

	//상세조회
	ReplyVO getReplyInfo(int rno);
	
	//등록
	int insertReply(ReplyVO vo);
	
	//수정
	int updateReply(ReplyVO vo);
	
	//삭제
	int deleteReply(int rno);
	

}
