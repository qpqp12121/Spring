package com.dbal.app.book.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.dbal.app.book.model.BookVO;
import com.dbal.app.book.model.RentVO;

@Mapper
public interface BookMapper {

	//도서전체조회
	public List<BookVO> getBookList();
	
	//등록
	public int insertBook(BookVO vo);
	
	//대여조회
	public Map<String,Object> getRentList(BookVO bvo, RentVO rvo);
	
	
}
