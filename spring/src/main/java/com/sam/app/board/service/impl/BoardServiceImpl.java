package com.sam.app.board.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.app.board.mapper.BoardMapper;
import com.sam.app.board.service.BoardSearchVO;
import com.sam.app.board.service.BoardService;
import com.sam.app.board.service.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public List<Map<String, Object>> getBoardList(BoardSearchVO vo) {
		return boardMapper.getBoardList(vo);
	}
	
	public int getCount(BoardSearchVO vo) {
		return boardMapper.getCount(vo);
	}

	@Override
	public List<BoardVO> getBoardList2(BoardVO vo) {
		return boardMapper.getBoardList2(vo);
	}

	@Override
	public BoardVO getBoard(String seqs) {
		return boardMapper.getBoard(seqs);
	}

	@Override
	public void insertBoard(BoardVO vo) {
		boardMapper.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardMapper.updateBoard(vo);
	}

	@Override
	public void deleteBoard(String seqs) {
		boardMapper.deleteBoard(seqs);
	}

}
