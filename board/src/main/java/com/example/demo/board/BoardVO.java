package com.example.demo.board;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;

//import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class BoardVO {
	 int boardNo;
	 String title;
	 String content;
	 String writer;
	 //@DateTimeFormat(pattern = "yyyy.MM.dd")
	 Date writeDate;
	 int clickCnt;
//	 String image="없음";
	 String image;
}
