package com.example.demo.ex;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	
	@GetMapping(value = "/getText", produces = "application/json;charset=UTF-8" ) //produces안 해도 jackson이 값 넘길 때 알아서 처리해줌(그냥 있다는 걸 보여주려고 배운 것)
	public String getText() {
		return "{\"greet\":\"안녕하세요\"}"; //{"greet":"안녕하세요"} --JSON형식으로
        //return "하이"; //그냥 String이라 res.text()로 받기
	}
	
	
	//364p ( ResponseBody VS ResponseEntity )
	
//	@GetMapping("/check") //http://localhost:8081/check?height=168&weight=50
//	public SampleVO check(Double height, Double weight) {
//		SampleVO vo = new SampleVO(0, ""+height, ""+weight); //Double값을 => String으로 변환할 때 Double.ToString 해도 되고 앞에 ""문자값 붙여도 됨
//		return vo; //vo로 return가능하지만 무조건 상태값 200 고정이라
//	} 
	
	//상태값, 헤더정보, 데이터 같이 넘겨줄 때 ResponseEntity 사용
	//ex.상태값에 따라 error여부 체크하고 2
	@GetMapping("/check")
	public ResponseEntity<SampleVO> check(Double height, Double weight) {
		SampleVO vo = new SampleVO(0, ""+height, ""+weight); //Double값을 => String으로 변환할 때 Double.ToString 해도 되고 앞에 ""문자값 붙여도 됨
		ResponseEntity<SampleVO> result = null;
		
		if(height > 150) {
			result = ResponseEntity.status(HttpStatus.OK).body(vo); //아래방법도 가능하고 이 방법도 있다
		} else {
			result = new ResponseEntity<>(vo, HttpStatus.BAD_GATEWAY);
		}
		return result;
	}
	
	
}
