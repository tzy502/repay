package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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
	public BeanUser register(String userId, String password) throws BaseException {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public BeanUser login(String userId, String password) throws BaseException {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public BeanUser changePassword(String userId, String oldPassword, String newPassword) throws BaseException {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public BeanUser resetPassword(String userId) throws BaseException {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public BeanUser addUser(BeanUser user) throws BaseException {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public BeanUser updateUser(BeanUser user) throws BaseException {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public BeanUser delUser(String userId) throws BaseException {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public BeanUser searchUser(String userId) throws BaseException {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public List<BeanUser> loadAllUser() throws BaseException {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public List<BeanUser> loadUser(String userName) throws BaseException {
		// TODO 自动生成的方法存根
		return null;
	}
}
