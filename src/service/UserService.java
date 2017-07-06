package service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import Decoder.BASE64Encoder;
import daoI.IUserDao;
import model.BeanUser;
import serviceI.IUserService;
import util.BaseException;

@Service
public class UserService implements IUserService{
	@Resource
	private IUserDao IUserDao;
	public UserService(){
	      System.out.println("UserService Constructor...\n\n\n\n\n\n");
	}
	 
	@Override
	public void register(String userId, String password, String userName, String userJob, String userPhone) throws BaseException {
		// TODO 自动生成的方法存根
		BeanUser user = new BeanUser();
		user.setUserId(userId);
		//user.setPassword(encoderByMd5(password));
		user.setPassword(password);
		user.setUserJob(userJob);
		user.setUserName(userName);
		user.setUserPhone(userPhone);
		IUserDao.addUser(user);
		
	}
	
	//登陆
	@Override
	public String login(String userId, String password) throws BaseException {
		// TODO 自动生成的方法存根
		BeanUser user = IUserDao.SearchUser(userId);
		if(!user.getPassword().equals(password)){
			throw new BaseException("密码错误！");
		}
		return "true";
	}
	
	//修改密码
	@Override
	public void changePassword(String userId, String oldPassword, String newPassword) throws BaseException {
		// TODO 自动生成的方法存根
		BeanUser user = IUserDao.SearchUser(userId);
		try {
			if(checkPassword(user.getPassword(),oldPassword)){
				user.setPassword(newPassword);
				IUserDao.addUser(user);
			}
			else{
				throw new BaseException("原密码错误！");
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	//重置密码
	@Override
	public void resetPassword(String userId) throws BaseException {
		// TODO 自动生成的方法存根
		BeanUser user = IUserDao.SearchUser(userId);
		user.setPassword("12345678");
		IUserDao.addUser(user);
	}
	
	//添加用户
	@Override
	public void addUser(String userId, String password, String userName, String userJob, String userPhone) throws BaseException {
		// TODO 自动生成的方法存根
		BeanUser user = new BeanUser();
		try {
			user.setUserId(userId);
			user.setPassword(encoderByMd5(password));

			user.setUserJob(userJob);
			user.setUserName(userName);

			user.setUserPhone(userPhone);
			IUserDao.addUser(user);
		} catch (NoSuchAlgorithmException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	//修改用户
	@Override
	public void updateUser(String userId, String password, String userName, String userJob, String userPhone) throws BaseException {
		// TODO 自动生成的方法存根
		BeanUser user = IUserDao.SearchUser(userId);
		try {
			user.setUserId(userId);
			user.setPassword(encoderByMd5(password));
			user.setUserJob(userJob);
			user.setUserName(userName);
			user.setUserPhone(userPhone);
			IUserDao.addUser(user);
		} catch (NoSuchAlgorithmException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
	//删除用户
	@Override
	public void delUser(String userId) throws BaseException {
		// TODO 自动生成的方法存根
		BeanUser user = IUserDao.SearchUser(userId);
		IUserDao.delUser(user);
	}
	
	//查询用户
	@Override
	public BeanUser searchUser(String userId) throws BaseException {
		// TODO 自动生成的方法存根
		return IUserDao.SearchUser(userId);
	}
	
	//导出所有用户
	@Override
	public List<BeanUser> loadAllUser() throws BaseException {
		// TODO 自动生成的方法存根
		return IUserDao.loadAllUser();
	}
	
	//模糊查询用户
	@Override
	public List<BeanUser> loadUser(String userName) throws BaseException {
		// TODO 自动生成的方法存根
		return IUserDao.loadUser(userName);
	}
	
	//MD5加密
	public static String encoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		BASE64Encoder base64en = new BASE64Encoder();
		String newStr = base64en.encode(md5.digest(str.getBytes("utf-8")));
		return newStr;
	}
	
	//密码验证
	public static boolean checkPassword(String newPassword, String oldPassword) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		if(encoderByMd5(newPassword).equals(oldPassword))
			return true;
		else
			return false;
	}
}
