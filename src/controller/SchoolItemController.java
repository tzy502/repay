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
	@RequestMapping(value = "/addSchoolItem.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String addSchoolItem(@RequestBody String params) throws JSONException{
		System.out.println(params);
		System.out.println("addschoolitem测试");
		JSONObject json = new JSONObject(params);
		int itemId=-1;
		itemId=Integer.valueOf((String)json.get("itemId"));
		String schoolItemName=null;
		schoolItemName=(String)json.get("schoolItemName");
		
		
		JSONObject jo = new JSONObject();
		try {
			ISchoolItem.addSchoolItem(itemId, schoolItemName);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jo.put("msg", e);
			return jo.toString(); 
		}
		
		return "a";

	}
	@RequestMapping(value = "/loadAllSchoolItem.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadAllSchoolItem(@RequestBody String params) throws JSONException{
		System.out.println("load测试");
		List<BeanSchoolItem> result=null;
		
		JSONArray json = new JSONArray();
		
		try {
			result = ISchoolItem.LoadSchoolItem();
		} catch (BaseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println(result.size());
		for(int i=0;i<result.size();i++){
			JSONObject jo = new JSONObject();
			jo.put("schoolItemId", result.get(i).getSchoolItemId());
			jo.put("itemId",result.get(i).getItemId());
			jo.put("schoolItemName", result.get(i).getSchoolItemName());
			json.put(jo);
		}

		System.out.println("1213123"+json.toString());
		return json.toString();
	}
	@RequestMapping(value = "/updateSchoolItem.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String updateSchoolItem(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int schoolItemId=Integer.valueOf((String)json.get("schoolItemId"));
		int itemId=-1;
		itemId=Integer.valueOf((String)json.get("itemId"));
		String schoolItemName=null;
		schoolItemName=(String)json.get("schoolItemName");
		try {
			ISchoolItem.modifrySchoolItem(schoolItemId, itemId, schoolItemName);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			json.put("msg", e);
			return json.toString(); 
		}
		
		return json.toString();
	}
	@RequestMapping(value = "/deleteSchoolItem.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String deleteSchoolItem(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int schoolItemId=Integer.valueOf((String)json.get("schoolItemId"));
		try {
			ISchoolItem.DelSchoolItem(schoolItemId);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			json.put("msg", e);
			return json.toString();
		}

		return json.toString();
	}
}
