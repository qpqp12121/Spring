package com.yedam.app.상속;

import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String[] args) {
		//그림판, 선, 네모, 원 ---> List<도형>
		List<Shape> list = new ArrayList<>();
		list.add(new Rect());
		list.add(new Circle());
		
		for( Shape s : list ) {
			//다형성: 참조하는 대상의 메서드를 호출(실행결과가 달라짐)
			s.draw();
		}
	}
}
