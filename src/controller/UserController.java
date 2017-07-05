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

import model.BeanUser;
import serviceI.IUserService;
import util.BaseException;

@Controller  
public class UserController {
	@Autowired
	private IUserService IUserService;
	
	@RequestMapping(value = "/login.do") 
	@ResponseBody
	public String login(@RequestBody String params) throws JSONException{  
    	JSONObject json = new JSONObject(params);
    	String userId = (String) json.get("userId");
    	String password = (String) json.get("password");
    	
    	System.out.println("userId:"+userId);
    	System.out.println("password:"+password);
    	JSONObject jo = new JSONObject();
    	String flag = "false";
    	try {
    		flag = IUserService.login(userId, password);
		} catch (BaseException e) {
			// TODO �Զ����ɵ� catch ��
			jo.put("msg", e);
			return jo.toString(); 
		}
    	jo.put("msg", flag);
		return jo.toString(); 
    }
	
	//添加用户
	@RequestMapping(value = "/addUser.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String register(@RequestBody String params) throws JSONException{
		System.out.println(params);
		JSONObject json = new JSONObject(params);
    	String userId = (String) json.get("userId");
    	String userName = (String) json.get("userName");
    	String userJob = (String) json.get("userJob");
    	String cardNumber = (String) json.get("cardNumber");
    	String userPhone = (String) json.get("userPhone");
    	String password = "123456";
    	String userPermissions = "";
    	JSONObject jo = new JSONObject();
    	try {
    		IUserService.addUser(userId, password, userName, userJob, userPermissions, cardNumber, userPhone);
		} catch (BaseException e) {
			// TODO 自动生成的 catch 块
			jo.put("msg", e.getMessage());
			return jo.toString();
		}
    	jo.put("msg", "succ");
		return jo.toString();  
	}
	
	/** 导出所有用户
	 * 发送：user
	 * */
	@RequestMapping(value = "/loadAllUser.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadAllUser() throws JSONException{
		List<BeanUser> users = null;
		System.out.println("userId111111:");
		try {
			users = IUserService.loadAllUser();
		} catch (BaseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
 		JSONArray json = new JSONArray();
		for(int i = 0; i < users.size(); i++){
			JSONObject jo = new JSONObject();
			jo.put("userId", users.get(i).getUserId());
			jo.put("userName", users.get(i).getUserName());
			jo.put("userJob", users.get(i).getUserJob());
			jo.put("userPermissions", users.get(i).getUserPermissions());
			jo.put("cardNumber", users.get(i).getCardNumber());
			jo.put("userPhone", users.get(i).getUserPhone());
			json.put(jo);
		}
		return json.toString();
	}
	
	/** 删除用户 
	 * 接收：userId
	 * 发送：succ(成功)
	 * */
	@RequestMapping(value = "/deleteUser.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String deleteUser(@RequestBody String params) throws JSONException{
		System.out.println(params);
		JSONObject json = new JSONObject(params);
    	String userId = (String) json.get("userId");
    	JSONObject jo = new JSONObject();
    	try {
    		IUserService.delUser(userId);
		} catch (BaseException e) {
			// TODO 自动生成的 catch 块
			jo.put("msg", e.getMessage());
			return jo.toString();
		}
    	jo.put("msg", "succ");
		return jo.toString();  
	}
}
