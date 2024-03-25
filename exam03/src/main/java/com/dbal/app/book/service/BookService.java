package com.dbal.app.book.service;

import java.util.List;
import java.util.Map;

import com.dbal.app.book.model.BookVO;
import com.dbal.app.book.model.RentVO;

public interface BookService {

	public List<BookVO> getBookList();
	public int insertBook(BookVO vo);
	public Map<String,Object> getRentList(BookVO bvo, RentVO rvo);
}
