package com.yedam.app;

/*
 * char - Character
 * byte - Byte
 * int  - Integer
 * short
 * long
 * float
 * double
 * boolean
 */

public class 형변환 {

	public static void main(String[] args) {
		
		//other type => String으로 변환
		Integer score = 100;
		String s = Integer.toString(score);
		
		double avg = 90.5;
		s = Double.toString(avg);
		
		//String => other type으로 변환
		score = Integer.parseInt(s);
		avg = Double.parseDouble(s);
		
		
	}
}
