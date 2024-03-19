package com.example.demo.board.service;

import java.util.Map;

import com.example.demo.board.BSearchVO;
import com.example.demo.board.BoardVO;

/* 사용자 요청에 의한 로직만 */

public interface BoardService {

	//전체조회 페이징처리 추가 (list,전체건수 같이 넘기기 위해 ServiceImpl에서 Map으로 처리하려 변경)
	Map<String,Object> getBoardList(BoardVO bvo, BSearchVO svo);
	
	//단건조회
	BoardVO getBoardInfo(int boardNo);
	
	//등록
	int insertBoard(BoardVO bvo);
	
	//수정
	int updateBoard(BoardVO bvo);
	
	//삭제
	int deleteBoard(int boardNo);
}
