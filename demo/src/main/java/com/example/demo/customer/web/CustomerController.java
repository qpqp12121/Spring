package com.example.demo.customer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.customer.repository.CustomerRepository;

@Controller
public class CustomerController {

	@Autowired CustomerRepository dao;
	
	@RequestMapping("/custList")
	public String custList(Model model) {
		model.addAttribute("custList", dao.findAll());
		return "custList";
	}
	
	
}
