package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.SchoolItemService;

@Controller
public class SchoolItemController {
	@Autowired
	private SchoolItemService SchoolItem;
	@RequestMapping(value = "/addItem.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public void addSchoolItem(@RequestBody String params){
		System.out.println(params);
	}
	
}
