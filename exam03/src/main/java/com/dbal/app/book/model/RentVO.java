package com.dbal.app.book.model;

import java.sql.Date;

import lombok.Data;

@Data
public class RentVO {

	private Integer rentNo;
	private Integer bookNo;
	private Integer rentPrice;
	private Date rentDate;
	private String rentStatus;
	
}
