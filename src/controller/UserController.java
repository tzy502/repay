package controller;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import serviceI.IUserService;
import util.BaseException;

@Controller  
public class UserController {
	@Autowired
	private IUserService userService;
	
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
    		flag = userService.login(userId, password);
		} catch (BaseException e) {
			// TODO �Զ����ɵ� catch ��
			jo.put("msg", e);
			return jo.toString(); 
		}
    	jo.put("msg", flag);
		return jo.toString(); 
    }    
}
