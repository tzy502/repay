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

import model.BeanItem;
import model.BeanUser;
import serviceI.IItemService;
import util.BaseException;

@Controller  
public class ItemController {
	@Autowired
	private IItemService IItemService;
	
	//添加报销项目
	@RequestMapping(value = "/addItem.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String register(@RequestBody String params) throws JSONException{
		System.out.println(params);
		JSONObject json = new JSONObject(params);
    	String itemName = (String) json.get("itemName");
    	JSONObject jo = new JSONObject();
    	try {
    		IItemService.addItem(itemName);
		} catch (BaseException e) {
			// TODO 自动生成的 catch 块
			jo.put("msg", e.getMessage());
			return jo.toString();
		}
    	jo.put("msg", "succ");
		return jo.toString();  
	}
	
	/** 导出所有报销项目
	 * */
	@RequestMapping(value = "/loadAllItem.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadAllItem() throws JSONException{
		List<BeanItem> item = null;
		try {
			item = IItemService.loadAllItem();
		} catch (BaseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
 		JSONArray json = new JSONArray();
		for(int i = 0; i < item.size(); i++){
			JSONObject jo = new JSONObject();
			jo.put("item", item.get(i).getItemName());
			json.put(jo);
		}
		return json.toString();
	}
	
}
