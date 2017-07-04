package daoI;

import java.util.List;

import model.BeanTravelUser;

public interface ITravelUserDao {
	public void addTravelUser(BeanTravelUser TravelUser);
	//添加报销
	
	public BeanTravelUser SearchTravelUser(int TravelUserId);
	//搜索报销

	public List<BeanTravelUser> loadAllTravelUser();
	//搜索报销
	
	public void modifryTravelUser(BeanTravelUser TravelUser);
	//修改报销
	
	public void delTravelUser(BeanTravelUser TravelUser);
	//删除报销
}
