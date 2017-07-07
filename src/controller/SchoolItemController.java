package controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.BeanSchoolItem;
import service.SchoolItemService;
import serviceI.ISchoolItemService;
import util.BaseException;

@Controller
public class SchoolItemController {
	@Autowired
	private ISchoolItemService ISchoolItem;
	@RequestMapping(value = "/addschoolitem.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String addSchoolItem(@RequestBody String params) throws JSONException{
		System.out.println(params);
		JSONObject json = new JSONObject(params);

		String schoolItemName;

		return "a";

	}
	@RequestMapping(value = "/loadAllSchoolItem.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadAllSchoolItem(@RequestBody String params) throws JSONException{
		System.out.println("load测试");
		List<BeanSchoolItem> result=null;
		
		JSONArray json = new JSONArray();
		JSONObject jo = new JSONObject();
		try {
			result = ISchoolItem.LoadSchoolItem();
		} catch (BaseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println(result.size());
		for(int i=0;i<result.size();i++){
			jo.put("schoolItemId", result.get(i).getSchoolItemId());
			jo.put("itemId",result.get(i).getItemId());
			jo.put("schoolItemName", result.get(i).getSchoolItemName());
			json.put(jo);
		}

		System.out.println("1213123"+json.toString());
		return json.toString();
	}
}
