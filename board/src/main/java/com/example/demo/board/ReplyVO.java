package com.example.demo.board;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ReplyVO {

	private Integer rno;
	private Integer bno;
	private String reply;
	private String replyer;
	//@DateTimeFormat (pattern = "yyyy-MM-dd")
	private Date replyDate;
	private Date updateDate;
	
}
