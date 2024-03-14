package com.example.demo.board;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.mapper.BoardMapper;

@SpringBootTest
public class BoardMapperTest {
	@Autowired BoardMapper mapper; //mapper 사용
	
	//@Test
	public void 게시글조회() {
		//vo객체 생성
		BoardVO vo = BoardVO.builder()
					.title("첫")
					.content("열심")
					.writer("홍")
				/*
				 * .write_date('2024') .click_cnt .image
				 */
					.build();
		
		NumVO svo = new NumVO();
		
		List<BoardVO> list = mapper.getBoardList(vo, svo);
		
		System.out.println(list.size());
		
		for(BoardVO board : list) {
			System.out.println("번호: " + board.getBoardNo() + ", 제목: " + board.getTitle() + ", 내용: " + board.getContent() + ", 작성자: " + board.getWriter() + ", 작성일: " + board.getWriteDate());
		}
	}
	
	//@Test
	public void 게시글단건조회() {
		int boardNo = 1;
		BoardVO vo = mapper.getBoardInfo(boardNo);
		System.out.println(vo);
	}
	
	@Test
	public void 게시글등록() {
		BoardVO vo = BoardVO.builder()
					.title("테스트")
					.content("이거이거")
					.writer("박")
					.writeDate(new Date())
					.clickCnt(1)
					.build();
		int result = mapper.insertBoard(vo);
		System.out.println("결과? " + result);			
	}
	
	//@Test
	public void 게시글수정() {
		BoardVO vo = BoardVO.builder()
				.content("이거이거22")
				.build();
		int result = mapper.updateBoard(vo);
		System.out.println("결과? " + result);
	}
	
	//@Test
	public void 사원삭제() {
		int boardNo = 7;
		int result = mapper.deleteBoard(boardNo);
		System.out.println("결과? " + result);
	}
	
}
