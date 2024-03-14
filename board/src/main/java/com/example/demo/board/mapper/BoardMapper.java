package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.board.BoardVO;
import com.example.demo.board.NumVO;

@Mapper
public interface BoardMapper {

	//게시글 검색(+페이징)
	List<BoardVO> getBoardList(@Param("vo") BoardVO vo, NumVO svo);
	
	//단건조회
	BoardVO getBoardInfo(int boardNo);
	
	//등록
	int insertBoard(BoardVO vo);
	
	//수정
	int updateBoard(BoardVO vo);
	
	//삭제
	int deleteBoard(int boardNo);
	
}
