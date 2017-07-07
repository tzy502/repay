package controller;

import org.json.JSONException;
import org.json.JSONObject;
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
	@RequestMapping(value = "/addschoolitem.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String addSchoolItem(@RequestBody String params) throws JSONException{
		System.out.println(params);
		JSONObject json = new JSONObject(params);
		int itemId=(int)json.get(key);
		String schoolItemName;
		
		return "a";
		
	}
	
}
