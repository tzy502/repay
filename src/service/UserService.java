package service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import convenience.util.BaseException;
import daoI.IUserDao;
import model.BeanUser;

@Service
public class UserService implements UserServiceI{
	@Resource
	private IUserDao userDaoI;
	public UserService(){
	      System.out.println("UserService Constructor...\n\n\n\n\n\n");
	}
	 
	@Override
	public BeanUser checkLogin(String userId, String password) throws BaseException {
		// TODO �Զ����ɵķ������
		
		BeanUser user = userDaoI.SearchUser(userId);
		System.out.println("Password2:"+password);
		if(user != null && password.equals(user.getPassword())){
			return user;
		}
		return null;

	}
}
