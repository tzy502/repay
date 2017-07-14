package service;

import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

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
		try {
			user.setPassword(encoderByMd5(password));
		} catch (NoSuchAlgorithmException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		user.setPassword(password);
		user.setUserJob(userJob);
		user.setUserName(userName);
		user.setUserPhone(userPhone);
		IUserDao.addUser(user);

	}

	//登陆
	@Override
	public BeanUser login(String userId, String password) throws BaseException {
		// TODO 自动生成的方法存根
		BeanUser user = IUserDao.SearchUser(userId);
		if(user == null){
			throw new BaseException("用户名不存在!");
		}
		
		try {
			System.out.println("12345678:"+encoderByMd5("12345678"));
			System.out.println("123456:"+encoderByMd5("123456"));
			System.out.println("password:"+encoderByMd5(password));
			System.out.println(user.getPassword());
			if(checkPassword(password,user.getPassword()) != true){
				throw new BaseException("密码错误！");
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	//修改密码
	@Override
	public void changePassword(String userId, String oldPassword, String newPassword) throws BaseException {
		// TODO 自动生成的方法存根
		BeanUser user = IUserDao.SearchUser(userId);
		try {
			if(checkPassword(oldPassword,user.getPassword()) == true){
				user.setPassword(encoderByMd5(newPassword));
				IUserDao.modifryUser(user);
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
		try {
			user.setPassword(encoderByMd5("123456"));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		IUserDao.modifryUser(user);
	}

	//添加用户
	@Override
	public void addUser(String userId, String password,int roleid, String userName, String userJob, String userPhone) throws BaseException {
		// TODO 自动生成的方法存根
		BeanUser user = new BeanUser();
		try {
			user.setUserId(userId);
			user.setPassword(encoderByMd5(password));
			user.setRoleId(roleid);
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
		user.setUserId(userId);
		user.setUserJob(userJob);
		user.setUserName(userName);
		user.setUserPhone(userPhone);
		IUserDao.modifryUser(user);

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

	@Override
	public void explore() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanUser> user =IUserDao.loadnormalUser();
		
		// 第一步，创建一个webbook，对应一个Excel文件  
		HSSFWorkbook wb = new HSSFWorkbook();  
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
		HSSFSheet sheet = wb.createSheet("比赛");  
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
		HSSFRow row = sheet.createRow((int) 0);  
		// 第四步，创建单元格，并设置值表头 设置表头居中  
		HSSFCellStyle style = wb.createCellStyle();  
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
        HSSFCell cell = row.createCell((short) 0);  
        cell.setCellValue("序号");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 1);  
        cell.setCellValue("姓名");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 2);  
        cell.setCellValue("已用");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 3);  
        cell.setCellValue("剩余");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 4);  
        cell.setCellValue("预算");  
        cell.setCellStyle(style);  
        for(int i=0;i<user.size();i++){
        	System.out.println(user.get(i).getUserName());
        	 row = sheet.createRow((int) i + 1);
        	 float summary=IUserDao.exploreUsersummary((user.get(i).getUserId()));
        	 float budget=IUserDao.exploreUserbudget((user.get(i).getUserId()));
        	 float Surplus=budget-summary;
        	 row.createCell((short) 0).setCellValue((int)i+1); 
        	 row.createCell((short) 1).setCellValue(user.get(i).getUserName()); 
        	 row.createCell((short) 2).setCellValue(summary); 
        	 row.createCell((short) 3).setCellValue(Surplus); 
        	 row.createCell((short) 4).setCellValue(budget); 
        }
        try  
        {  
        	System.out.println("123from ser");
            FileOutputStream fout = new FileOutputStream("D:\\java\\workspaceforj2ee\\repay\\WebContent\\upload\\explore.xls");  
            wb.write(fout);  
            fout.close();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
        }
	}
}
