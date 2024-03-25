package com.dbal.app.book.model;

import java.sql.Date;

import lombok.Data;

@Data
public class BookVO {

	private Integer bookNo;
	private String bookName;
	private String bookCoverimg;
	private Date bookDate;
	private int bookPrice;
	private String bookPublisher;
	private String bookInfo;
	
	
}
