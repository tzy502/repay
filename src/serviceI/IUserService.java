package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import convenience.util.BaseException;
import model.BeanUser;

@Component
public interface IUserService {
	//注册
	public BeanUser register(String userId, String password)throws BaseException;
	
	//登陆
	public BeanUser login(String userId, String password)throws BaseException;
	
	//修改密码
	public BeanUser changePassword(String userId, String oldPassword, String newPassword)throws BaseException;
	
	//重置密码
	public BeanUser resetPassword(String userId)throws BaseException;
	
	//添加用户
	public BeanUser addUser(BeanUser user)throws BaseException;
	
	//修改用户信息
	public BeanUser updateUser(BeanUser user)throws BaseException;
	
	//删除用户
	public BeanUser delUser(String userId)throws BaseException;
	
	//查询用户
	public BeanUser searchUser(String userId)throws BaseException;
	
	//导出所有用户
	public List<BeanUser> loadAllUser()throws BaseException;
	
	//模糊查询用户
	public List<BeanUser> loadUser(String userName)throws BaseException;
}

