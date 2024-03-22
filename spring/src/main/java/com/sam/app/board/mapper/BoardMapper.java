package com.sam.app.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.sam.app.board.service.BoardSearchVO;
import com.sam.app.board.service.BoardVO;

@Mapper
public interface BoardMapper {

	// 목록조회
	public List<Map<String, Object>> getBoardList(BoardSearchVO vo);

	// 전체레코드 건수 조회
	public int getCount(BoardSearchVO vo);

	public List<BoardVO> getBoardList2(BoardVO vo);

	// 단건저회
	public BoardVO getBoard(String seqs);

	// 입력
	public void insertBoard(BoardVO vo);

	// 수정
	public void updateBoard(BoardVO vo);

	// 삭제
	public void deleteBoard(String seqs);

}
