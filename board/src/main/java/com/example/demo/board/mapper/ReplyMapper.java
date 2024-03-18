package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.ReplyVO;

@Mapper
public interface ReplyMapper {
	//댓글조회
	List<ReplyVO> getReplyList();
}
