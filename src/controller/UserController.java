package controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import model.BeanUser;
import serviceI.IUserService;
import util.BaseException;

@Controller  
public class UserController {
	@Autowired
	private IUserService IUserService;
	
	//登录
	@RequestMapping(value = "/login.do") 
	@ResponseBody
	public String login(@RequestBody String params) throws JSONException{  
    	JSONObject json = new JSONObject(params);
    	String userId = (String) json.get("userId");
    	String password = (String) json.get("password");
    	JSONObject jo = new JSONObject();
    	BeanUser user = new BeanUser();
    	try {
    		user = IUserService.login(userId, password);
		} catch (BaseException e) {
			// TODO �Զ����ɵ� catch ��
			jo.put("msg", e);
			return jo.toString(); 
		}
    	jo.put("userId", user.getUserId());
    	jo.put("userName", user.getUserName());
		return jo.toString(); 
    }
	
	//添加用户
	@RequestMapping(value = "/addUser.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String addUser(@RequestBody String params) throws JSONException{
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
    		IUserService.addUser(userId, password,2, userName, userJob, userPhone);
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
	
	/** 
	 *	注册
	 * */
	@RequestMapping(value = "/register.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String register(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
    	String userId = (String) json.get("userId");
    	String userName = (String) json.get("userName");
    	String userJob = (String) json.get("userJob");
    	String userPhone = (String) json.get("userPhone");
    	String password = (String) json.get("password");
    	JSONObject jo = new JSONObject();
    	try {
    		IUserService.addUser(userId, password, 2,userName, userJob, userPhone);
		} catch (BaseException e) {
			// TODO 自动生成的 catch 块
			jo.put("msg", e.getMessage());
			return jo.toString();
		}
    	jo.put("msg", "succ");
		return jo.toString();  
	}
	
	
	//上传
	@RequestMapping("uploadPicture.do")
	@ResponseBody
	//@RequestParam ("summaryId")String summaryId,
	public void uploads(@RequestParam ("file") MultipartFile fileUpload,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		 String filename = new String( fileUpload.getOriginalFilename() .getBytes("iso8859-1") , "utf-8");  
		System.out.println(filename);
		String fileExtName = filename.substring(filename.lastIndexOf("."));
		System.out.println(fileExtName);
		String filePath="D:/java/workspaceforj2ee/repay/WebContent/WEB-INF/upload";
		String filenewname="fuck"+fileExtName;
	    try {
			OutputStream out = new FileOutputStream(new File(filePath, filenewname));
			InputStream in = fileUpload.getInputStream();  
			int length = 0;
			try {    
				byte[] buf = fileUpload.getBytes();//文件二进制
				while ((length = in.read(buf)) != -1) {
					out.write(buf, 0, length);
				}
				out.flush();
				in.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        //userUploadPictureService.uploads(files, destDir, request,response);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}

