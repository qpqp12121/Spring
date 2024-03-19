package com.example.demo.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.BoardVO;
import com.example.demo.emp.EmpVO;
import com.example.demo.board.BSearchVO;

@Mapper
public interface BoardMapper {

	//게시글 검색(+페이징)
	public List<BoardVO> getBoardList(BoardVO bvo, BSearchVO svo);
	//전체건수
	public int getCount(BoardVO bvo, BSearchVO svo); //count에도 조건절 걸어놔서 boardvo, bsearchvo 다 넘겨줘야 됨 아니면 getproperty오류
	
	
	//단건조회
	public BoardVO getBoardInfo(int boardNo);
	
	//등록
	public int insertBoard(BoardVO vo);
	
	//수정
	public int updateBoard(BoardVO vo);
	
	//삭제
	public int deleteBoard(int boardNo);

	
	
}
