package com.dbal.app.book.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbal.app.book.mapper.BookMapper;
import com.dbal.app.book.model.BookVO;
import com.dbal.app.book.model.RentVO;
import com.dbal.app.book.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired BookMapper mapper;

	//도서전체조회
	@Override
	public List<BookVO> getBookList() {
		return mapper.getBookList();
	}

	//도서등록
	@Override
	public int insertBook(BookVO vo) {
		return mapper.insertBook(vo);
	}

	//대여목록
	@Override
	public Map<String, Object> getRentList(BookVO bvo, RentVO rvo) {
		return mapper.getRentList(bvo, rvo);
	}

	

	
	
	
	
}
