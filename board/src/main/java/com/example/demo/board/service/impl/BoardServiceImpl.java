package com.example.demo.board.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.board.BSearchVO;
import com.example.demo.board.BoardVO;
import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	//생성자주입방식
	final BoardMapper mapper;

	//게시글목록(페이징)
	@Override
	public Map<String, Object> getBoardList(BoardVO bvo, BSearchVO svo) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		//"전체건수&게시글목록" 같이 넘어와야 되니 Map 사용
		map.put("count", mapper.getCount(bvo, svo));
		map.put("data", mapper.getBoardList(bvo, svo));
		return map;
	}

	@Override
	public BoardVO getBoardInfo(int boardNo) {
		return mapper.getBoardInfo(boardNo);
	}

	@Override
	public int insertBoard(BoardVO bvo) {
		return mapper.insertBoard(bvo);
	}

	@Override
	public int updateBoard(BoardVO bvo) {
		return mapper.updateBoard(bvo);
	}

	@Override
	public int deleteBoard(int boardNo) {
		return mapper.deleteBoard(boardNo);
	}
	
	
	
	
}
