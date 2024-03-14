package com.example.demo.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.channels.IllegalChannelGroupException;

import com.example.demo.emp.EmpVO;

@Controller
public class Excontroller {

	@RequestMapping("/ex2")
	public String ex2(EX2VO vo) {
		System.out.println(vo);
		return "index";
	}

	@RequestMapping("/ex3")
	public String ex3(ListCodeVO vo) {
		System.out.println(vo);
		return "index";
	}

	@RequestMapping("/ex4/{username}/{userage}") // url의 변수명과 필드명 다르다면 pathvariable에 이름으로 url변수명을 넣어주면 됨(아니면 그냥 똑같이)
	public String ex4(@PathVariable String username, @PathVariable(name = "userage") int age) {
		System.out.println("username: " + username + ", age: " + age);
		return "index";
	}

	@RequestMapping("/ex5") // 커맨드객체없이(vo없이) 파라미터를 바로 받을 때 (localhost:8082/ex5?username=xxx&userage=XX 로 입력)
	public String ex5(String username,
			@RequestParam(name = "userage", required = false, defaultValue = "10") Integer age) {
		// age 안 보내도 null값 나오고 에러 X (int로 하면 에러처리 됨)
		// 근데 @RequestParam 붙이고 값 하나를 빠뜨리면 에러 발생 => 필수여부 (괄호) 안에 작성할 수 있다 (param 무조건
		// String이라 받고 Integer로 변경시켜줄 거임)
		// required=false가 기본값이라 작성 안 해도 되는데 defaultValue로 초기값 주고 싶으면 앞에 같이 작성하기
		System.out.println("username: " + username + ", age: " + age);
		return "index";
	}

	@RequestMapping("/ex6")
	public String ex6(EmpVO vo, MultipartFile[] photos) throws IllegalStateException, IOException { // photo --name이랑
																									// 같아야 됨 )
																									// req4.html파일 참고
		System.out.println(vo);

		if (photos != null) { //객체타입이면 항상 null값인지 체크하기
			for (MultipartFile photo : photos) { // 첨부파일 multiple="multiple"로 배열이라 for문 돌려서 다중첨부 가능
				if (photo.getSize() > 0) { //or photo.isNull(?) 
					// 파일 생성
					File file = new File("d:/upload", photo.getOriginalFilename());
					// 파일 저장
					photo.transferTo(file); // 정보출력

					System.out.println("파일명: " + photo.getOriginalFilename());
					System.out.println("파일크기: " + photo.getSize());
				}
			}
		}
		return "index";
	}
}
