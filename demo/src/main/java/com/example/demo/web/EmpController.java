package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.mapper.EmpMapper;

@Controller
public class EmpController {
	@Autowired EmpMapper dao; //의존성주입(DI dependency Injection) -- 객체관리를 스프링이 알아서 해 줌(new키워드 없이도 Autowired쓰면?)
	
	@RequestMapping("/ajaxEmp")
	@ResponseBody
	public List<EmpVO> ajaxEmp() {
		return dao.getEmpList();
	}
	
	@RequestMapping("/empList")
	public String empList(Model model){
		model.addAttribute("empList", dao.getEmpList());
		return "empList"; 
	}
}
