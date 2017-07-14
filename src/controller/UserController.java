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
	@RequestMapping(value = "/login.do", produces = "application/json; charset=utf-8") 
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
			jo.put("msg", e.getMessage());
			return jo.toString(); 
		}
		jo.put("msg","succ");
		jo.put("userId", user.getUserId());
		jo.put("roleId",user.getRoleId());
		jo.put("userJob", user.getUserJob());
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
		String userPhone = (String) json.get("userPhone");
		String password = "123456";
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
	
	//修改用户
		@RequestMapping(value = "/updateUser.do", produces = "application/json; charset=utf-8") 
		@ResponseBody
		public String updateUser(@RequestBody String params) throws JSONException{
			System.out.println(params);
			JSONObject json = new JSONObject(params);
			String userId = (String) json.get("userId");
			String userName = (String) json.get("userName");
			String userJob = (String) json.get("userJob");
			String userPhone = (String) json.get("userPhone");
			JSONObject jo = new JSONObject();
			try {
				IUserService.updateUser(userId, "", userName, userJob, userPhone);
			} catch (BaseException e) {
				// TODO 自动生成的 catch 块
				jo.put("msg", e.getMessage());
				return jo.toString();
			}
			jo.put("msg", "succ");
			return jo.toString();  
		}

	//查找用户
	@RequestMapping(value = "/searchUser.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String searchUser(@RequestBody String params) throws JSONException{
		System.out.println(params);
		JSONObject json = new JSONObject(params);
		String userId = (String) json.get("userId");
		JSONObject jo = new JSONObject();
		BeanUser user = null;
		try {
			user = IUserService.searchUser(userId);
		} catch (BaseException e) {
			// TODO 自动生成的 catch 块
			jo.put("msg", e.getMessage());
			return jo.toString();
		}
		jo.put("userId", user.getUserId());
		jo.put("userName", user.getUserName());
		jo.put("userJob", user.getUserJob());
		jo.put("userPhone", user.getUserPhone());
		jo.put("roleId", user.getRoleId());
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

	//重置密码
	@RequestMapping(value = "/resetPassword.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String resetPassword(@RequestBody String params) throws JSONException{
		System.out.println(params);
		JSONObject json = new JSONObject(params);
		String userId = (String) json.get("userId");
		JSONObject jo = new JSONObject();
		try {
			IUserService.resetPassword(userId);
		} catch (BaseException e) {
			// TODO 自动生成的 catch 块
			jo.put("msg", e.getMessage());
			return jo.toString();
		}
		jo.put("msg", "succ");
		return jo.toString();  
	}
	
	//修改密码
		@RequestMapping(value = "/changePassword.do", produces = "application/json; charset=utf-8") 
		@ResponseBody
		public String changePassword(@RequestBody String params) throws JSONException{
			System.out.println(params);
			JSONObject json = new JSONObject(params);
			String userId = (String) json.get("userId");
			String oldPassword = (String) json.get("oldPassword");
			String newPassword = (String) json.get("newPassword");
			JSONObject jo = new JSONObject();
			try {
				IUserService.changePassword(userId, oldPassword, newPassword);
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

	public void uploads(@RequestParam ("projectId") String projectId,@RequestParam ("file") MultipartFile fileUpload,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		//System.out.println(projectId);
		String filename = new String( fileUpload.getOriginalFilename() .getBytes("iso8859-1") , "utf-8");  
		//System.out.println(filename);
		String fileExtName = filename.substring(filename.lastIndexOf("."));
		System.out.println(fileExtName);
		String filePath="WebContent/upload";
		String filenewname= "summary"+projectId+fileExtName;

		
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

