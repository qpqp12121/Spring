package com.example.demo.board;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	 int boardNo;
	 String title;
	 String content;
	 String writer;
	 Date writeDate;
	 int clickCnt;
	 String img;
}
