package com.re.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.re.study.service.UserDaoService;

@Controller
public class SomeWebAppController {
	
	@Autowired
	UserDaoService userService;
	
	
	@RequestMapping(value = "/hello")
	public String hello(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		java.util.List<com.re.study.entity.User> myList =  userService.getUserList();
		String someName = "";
		for (com.re.study.entity.User u: myList){
			System.out.println(u.getFirstName());
			someName = u.getFirstName();
		}
		model.addAttribute("name", someName);
		return "hello";
	}
}