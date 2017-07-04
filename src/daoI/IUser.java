package daoI;

import java.util.List;

import model.BeanUser;

public interface IUser {
	public void addUser(BeanUser user);
	//添加用户
	
	public BeanUser SearchUser(String userId);
	//搜索用户
	
	public BeanUser loadUser(String userName);
	//模糊查询用户
	
	public List<BeanUser> loadAllUser();
	//搜索全部用户
	
	public void modifryUser(BeanUser user);
	//修改用户
	
	public void DelUser(BeanUser user);
	//删除用户
}
